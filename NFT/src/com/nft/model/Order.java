package com.nft.model;

public class Order {
    public enum Type {
        BUY, SELL
    }

    Type orderType;

    Double price;

    String artWork;

    String user;

    public Order(Type orderType, Double price, String artWork, String user) {
        this.orderType = orderType;
        this.price = price;
        this.artWork = artWork;
        this.user = user;
    }

    public Type getOrderType() {
        return orderType;
    }

    public Double getPrice() {
        return price;
    }

    public String getArtWork() {
        return artWork;
    }

    public String getUser() {
        return user;
    }

}
