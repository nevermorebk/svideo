package com.minori.svideo.service.transformer.impl;

import com.minori.svideo.common.model.User;
import com.minori.svideo.model.request.UserRequest;
import com.minori.svideo.service.transformer.UserTransformer;

public class UserTransformerImpl implements UserTransformer {

    @Override
    public User convertToEntity(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setUsername(request.getUsername());
        return user;
    }
}
