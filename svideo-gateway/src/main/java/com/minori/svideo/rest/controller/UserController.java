package com.minori.svideo.rest.controller;

import com.minori.svideo.common.model.User;
import com.minori.svideo.common.response.SvideoResponse;
import com.minori.svideo.model.request.UserRequest;
import com.minori.svideo.rest.gateway.UserGateway;
import com.minori.svideo.rest.support.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractController {

    @Autowired
    @Qualifier("userGateway")
    private UserGateway userGateway;

    @PostMapping(value = "/add")
    public SvideoResponse<User> add(
            @RequestBody UserRequest request) {
        return requestGW(request, userGateway::add);
    }

}
