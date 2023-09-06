package com.nft.repo;

import com.nft.model.Artist;

import java.util.Optional;

public interface IArtistRepo {
    Artist save(Artist artist);

    Optional<Artist> get(String artist);
}
