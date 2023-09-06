package com.nft.repo.impl;

import com.nft.model.NFT;
import com.nft.repo.INFTRepo;

import java.util.HashMap;
import java.util.Optional;

public class InMemoryNFTRepoImpl implements INFTRepo {
    private static int counter = 0;

    private HashMap<String, NFT> nftIdToUserMapping;

    public InMemoryNFTRepoImpl() {
        this.nftIdToUserMapping = new HashMap<>();
    }

    @Override
    public NFT save(NFT nft) {
        if(nft.getId() == null)
            nft.setId(counter++);
        this.nftIdToUserMapping.put(nft.getArtWork(), nft);
        return null;
    }

    @Override
    public Optional<NFT> get(String artwork) {
        return Optional.of(this.nftIdToUserMapping.get(artwork));
    }

    @Override
    public String toString() {
        return this.nftIdToUserMapping.values().toString();
    }
}
