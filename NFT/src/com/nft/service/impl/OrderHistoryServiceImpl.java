package com.nft.service.impl;

import com.nft.model.OrderHistory;
import com.nft.service.IOrderHistoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHistoryServiceImpl implements IOrderHistoryService {
    Map<String, List<OrderHistory>> orderHistoryMap = new HashMap<>();
    @Override
    public List<OrderHistory> getOrderHistory(String artWork) {
        return this.orderHistoryMap.get(artWork);
    }

    public boolean addOrderHistory(OrderHistory orderHistory) {
        this.orderHistoryMap.putIfAbsent(orderHistory.getArtWork(), new ArrayList<>());
        this.orderHistoryMap.get(orderHistory.getArtWork()).add(orderHistory);
        return true;
    }
}
