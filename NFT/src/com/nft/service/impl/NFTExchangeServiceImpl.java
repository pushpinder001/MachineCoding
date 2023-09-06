package com.nft.service.impl;

import com.nft.service.NFTExchange;
import com.nft.model.*;
import com.nft.repo.IArtistRepo;
import com.nft.repo.INFTRepo;
import com.nft.repo.IUserRepo;
import com.nft.repo.impl.InMemoryArtistRepoImpl;
import com.nft.repo.impl.InMemoryNFTRepoImpl;
import com.nft.repo.impl.InMemoryUserRepoImpl;
import com.nft.service.INFTOrderService;
import com.nft.service.IOrderHistoryService;

import java.util.List;

public class NFTExchangeServiceImpl implements NFTExchange {

    private IArtistRepo artistRepo;

    private IUserRepo userRepo;

    private INFTRepo nftRepo;

    private INFTOrderService nftOrderService;

    private IOrderHistoryService orderHistoryService;

    private User exchange;

    public NFTExchangeServiceImpl() {
        this.artistRepo = new InMemoryArtistRepoImpl();
        this.userRepo = new InMemoryUserRepoImpl();
        this.nftRepo = new InMemoryNFTRepoImpl();
        this.nftOrderService = new NFTOrderServiceImpl(this.nftRepo, this.userRepo, this.artistRepo);
        this.orderHistoryService = new OrderHistoryServiceImpl();
        this.exchange = new User(NFTExchange.EXCHANGE, 0.0);
        this.userRepo.save(this.exchange);
    }

    @Override
    public Artist createArtist(String name, Double initMoney) {
        return this.artistRepo.save(new Artist(name, initMoney));
    }

    @Override
    public User createUser(String name, Double initMoney) {
        return this.userRepo.save(new User(name, initMoney));
    }

    @Override
    public NFT createNFT(String artWork, String artistName, Double royaltyPercent) {
        Artist artist = this.artistRepo.get(artistName).orElseThrow(() ->{throw new RuntimeException("Artist Not Found");});

        artist.addMoney(-1*NFTExchange.CREATE_NFT_CHARGE);
        this.exchange.addMoney(NFTExchange.CREATE_NFT_CHARGE);

        return this.nftRepo.save(new NFT(artWork, artistName, royaltyPercent));
    }

    @Override
    public Order placeSellOrder(String artWork, Double sellingPrice) {
        return this.nftOrderService.placeSellOrder(artWork, sellingPrice);
    }

    @Override
    public Order placeBuyOrder(String artWork, String buyer, Double buyPrice) {
        return this.nftOrderService.placeBuyOrder(artWork,buyPrice, buyer);
    }

    @Override
    public void listAllNFTs() {
        System.out.println(nftRepo.toString());
    }

    @Override
    public void listAllUser() {
        System.out.println(artistRepo.toString());
        System.out.println(userRepo.toString());
    }

    @Override
    public void describeNFT(String artwork) {
        NFT nft = nftRepo.get(artwork).get();

        List<OrderHistory> ordersHistories =  orderHistoryService.getOrderHistory(artwork);

        System.out.println("Creation Date " + nft.getCreationDate() + " Art " + nft.getArtWork());

        System.out.println(ordersHistories.toString());
    }
}
