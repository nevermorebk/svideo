package com.minori.svideo.service.business.impl;

import com.minori.svideo.common.model.User;
import com.minori.svideo.service.business.UserService;
import com.minori.svideo.storage.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> add(User request) {
        User user = userRepository.insert(request);
        return Optional.ofNullable(user);
    }
}
