package com.nft.model;

public class User {
    private Integer id;

    private String name;

    private Wallet wallet;

    public User(String name, Double money) {
        this.name = name;
        this.wallet = new Wallet(money);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean addMoney(Double amount) {
        return this.wallet.addMoney(amount);
    }

    public boolean hasAmount(Double amount) {
        return this.wallet.hasMoney(amount);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
