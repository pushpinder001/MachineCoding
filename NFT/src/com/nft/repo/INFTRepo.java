package com.nft.repo;

import com.nft.model.Artist;
import com.nft.model.NFT;

import java.util.Optional;

public interface INFTRepo {
    NFT save(NFT artist);

    Optional<NFT> get(String artwork);
}
