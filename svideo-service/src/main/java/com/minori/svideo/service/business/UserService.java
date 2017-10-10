package com.minori.svideo.service.business;

import com.minori.svideo.common.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> add(User user);

}
