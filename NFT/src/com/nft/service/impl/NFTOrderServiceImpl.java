package com.nft.service.impl;

import com.nft.model.*;
import com.nft.repo.IArtistRepo;
import com.nft.repo.INFTRepo;
import com.nft.repo.IUserRepo;
import com.nft.service.INFTOrderService;
import com.nft.service.IOrderHistoryService;
import com.nft.service.NFTExchange;

import java.util.*;

public class NFTOrderServiceImpl implements INFTOrderService {
    Map<String, Order> sellOrder;

    Map<String, Queue<Order>> buyOrders;

    INFTRepo nInftRepo;

    IUserRepo iUserRepo;

    IArtistRepo iArtistRepo;

    IOrderHistoryService iOrderHistoryService;

    public NFTOrderServiceImpl(INFTRepo nfInftRepo, IUserRepo iUserRepo, IArtistRepo iArtistRepo) {
        this.sellOrder = new HashMap<>();
        this.buyOrders = new HashMap<>();
        this.nInftRepo = nfInftRepo ;
        this.iUserRepo = iUserRepo;
        this.iArtistRepo = iArtistRepo;
        this.iOrderHistoryService = new OrderHistoryServiceImpl();
    }

    @Override
    public Order placeSellOrder(String artWork, Double price) {
        NFT nft  = this.nInftRepo.get(artWork).get();
        Order order = new Order(Order.Type.SELL, price, artWork, nft.getOwnerName());
        this.sellOrder.put(artWork, order);
        checkForTransaction(artWork);
        return order;
    }

    @Override
    public Order placeBuyOrder(String artWork, Double price, String buyer) {
        Order order = new Order(Order.Type.BUY, price, artWork, buyer);
        this.buyOrders.putIfAbsent(artWork, new PriorityQueue<>((o1, o2) -> {return (int)(o2.getPrice() - o1.getPrice());}));
        this.buyOrders.get(artWork).add(order);
        checkForTransaction(artWork);
        return order;
    }

    void checkForTransaction(String artWork) {
        Order sellOrder = this.sellOrder.get(artWork);
        Order buyOrder  = this.buyOrders.get(artWork)!= null?this.buyOrders.get(artWork).peek():null;

        if(sellOrder != null && buyOrder != null && sellOrder.getPrice() >= buyOrder.getPrice()) {
            //Check for buyers wallet
            User buyer = iUserRepo.get(buyOrder.getUser()).get();
            NFT nft = nInftRepo.get(artWork).get();
            User exchange = iUserRepo.get(NFTExchange.EXCHANGE).get();
            Double commission = NFTExchangeServiceImpl.COMMISSION/100;

            Double buyPrice = (1.0+commission+nft.getRoyaltyPercent()/100.0)*sellOrder.getPrice();
            Double ownerSellingPrice = (1.0-commission)*sellOrder.getPrice();
            if(buyer.hasAmount(buyPrice)) {
                //Subtract money from buyer
                buyer.addMoney(-1*buyPrice);

                //Add money to exchange
                exchange.addMoney(2.0*commission*sellOrder.getPrice());

                //Add money to wallet of artist
                Artist artist =  iArtistRepo.get(nft.getArtistName()).get();
                artist.addMoney((nft.getRoyaltyPercent()/100.0)*sellOrder.getPrice());

                //Add money for seller
                if(sellOrder.getUser().equals(artist.getName())) {
                    artist.addMoney(ownerSellingPrice);
                } else {
                    User seller = iUserRepo.get(nft.getOwnerName()).get();
                    seller.addMoney(ownerSellingPrice);
                }

                this.sellOrder.remove(artWork);
                this.buyOrders.get(artWork).poll();

                nft.setOwnerName(buyer.getName());
                nInftRepo.save(nft);

                this.iOrderHistoryService.addOrderHistory(new OrderHistory(artWork, new Date(), buyPrice, ownerSellingPrice));
            }
        }
    }
}
