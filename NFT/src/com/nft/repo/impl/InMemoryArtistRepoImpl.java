package com.nft.repo.impl;

import com.nft.model.Artist;
import com.nft.repo.IArtistRepo;

import java.util.HashMap;
import java.util.Optional;

public class InMemoryArtistRepoImpl implements IArtistRepo {
    private static int counter = 0;

    private HashMap<String, Artist> artistToArtistMapping;

    public InMemoryArtistRepoImpl() {
        this.artistToArtistMapping = new HashMap<>();
    }

    @Override
    public Artist save(Artist artist) {
        artist.setId(counter++);

        this.artistToArtistMapping.put(artist.getName(), artist);

        return artist;
    }

    public Optional<Artist> get(String artist) {
        return Optional.of(this.artistToArtistMapping.get(artist));
    }

    @Override
    public String toString() {
        return artistToArtistMapping.values().toString();
    }
}
