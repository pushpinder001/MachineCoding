package com.nft.repo.impl;

import com.nft.model.User;
import com.nft.repo.IUserRepo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryUserRepoImpl implements IUserRepo {
    private static int counter = 0;

    private HashMap<String, User> userIdToUserMapping;

    public InMemoryUserRepoImpl() {
        this.userIdToUserMapping = new HashMap<>();
    }

    @Override
    public User save(User user) {
        user.setId(counter++);
        this.userIdToUserMapping.put(user.getName(), user);
        return null;
    }

    @Override
    public Optional<User> get(String user) {
        return Optional.of(this.userIdToUserMapping.get(user));
    }

    @Override
    public String toString() {
        return this.userIdToUserMapping.values().stream().map(u-> u.toString()).collect(Collectors.joining("\n"));
    }
}
