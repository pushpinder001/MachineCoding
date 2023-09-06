package com.nft.service;

import com.nft.model.OrderHistory;

import java.util.List;

public interface IOrderHistoryService {

    List<OrderHistory> getOrderHistory(String artwork);

    boolean addOrderHistory(OrderHistory orderHistory);
}
