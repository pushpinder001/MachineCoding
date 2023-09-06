package com.nft.model;

import java.util.Date;

public class NFT {
    private Integer id;
    private String artWork;
    private String artistName;
    private String ownerName;
    private Double royaltyPercent;
    private Date creationDate;

    public NFT(String artWork, String artistName, Double royaltyPercent) {
        this.artWork = artWork;
        this.artistName = artistName;
        this.royaltyPercent = royaltyPercent;
        this.creationDate = new Date();
        this.ownerName = this.artistName;
    }

    public Integer getId() {
        return id;
    }

    public String getArtWork() {
        return artWork;
    }

    public String getArtistName() {
        return artistName;
    }

    public Double getRoyaltyPercent() {
        return royaltyPercent;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "NFT{" +
                "id=" + id +
                ", artWork='" + artWork + '\'' +
                ", artistName='" + artistName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", royaltyPercent=" + royaltyPercent +
                ", creationDate=" + creationDate +
                '}';
    }
}
