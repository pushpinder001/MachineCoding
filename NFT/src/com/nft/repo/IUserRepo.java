package com.nft.repo;

import com.nft.model.Artist;
import com.nft.model.User;

import java.util.Optional;

public interface IUserRepo {
    User save(User artist);

    Optional<User> get(String user);

}
