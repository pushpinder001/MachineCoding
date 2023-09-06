package com.nft.model;

import java.util.Date;

public class OrderHistory {
    private String artWork;
    private Date transactionDate;

    private Double buyingPrice;

    private Double sellingPrice;

    public OrderHistory(String artWork, Date transactionDate, Double buyingPrice, Double sellingPrice) {
        this.artWork = artWork;
        this.transactionDate = transactionDate;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }

    public String getArtWork() {
        return artWork;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }
}
