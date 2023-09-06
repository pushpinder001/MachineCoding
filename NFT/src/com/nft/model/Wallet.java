package com.nft.model;

public class Wallet {
    private Double balance;

    public Wallet(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }


    boolean addMoney(Double amount) {
        if(balance+amount>=0) {
            this.balance += amount;
            return true;
        }

        return false;
    }

    boolean hasMoney(Double amount) {
        if(balance>amount) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "balance=" + balance +
                '}';
    }
}
