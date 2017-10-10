package com.minori.svideo.rest.gateway;

import com.minori.svideo.common.model.User;
import com.minori.svideo.model.request.UserRequest;

import java.util.Optional;

public interface UserGateway {

    Optional<User> add(UserRequest request);

}
