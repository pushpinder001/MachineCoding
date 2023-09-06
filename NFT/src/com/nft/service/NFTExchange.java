package com.nft.service;

import com.nft.model.Artist;
import com.nft.model.NFT;
import com.nft.model.Order;
import com.nft.model.User;

public interface NFTExchange {
    Double COMMISSION = 10.0;

    Double CREATE_NFT_CHARGE = 100.0;

    String EXCHANGE = "Exchange";

    Artist createArtist(String name, Double initMoney);
    User createUser(String name, Double initMoney);

    NFT createNFT(String artWork, String artistName, Double royaltyPercent);

    Order placeSellOrder(String artWork, Double sellingPrice);

    Order placeBuyOrder(String artWork, String buyer, Double buyPrice);

    void listAllNFTs();

    void listAllUser();

    void describeNFT(String artWork);
}
