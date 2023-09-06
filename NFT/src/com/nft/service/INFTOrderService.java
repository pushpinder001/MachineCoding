package com.nft.service;

import com.nft.model.Order;

import java.util.List;

public interface INFTOrderService {
    Order placeSellOrder(String artWork, Double price);
    Order placeBuyOrder(String artWork, Double price, String buyer);
}
