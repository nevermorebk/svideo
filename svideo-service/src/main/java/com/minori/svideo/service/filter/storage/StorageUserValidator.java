package com.minori.svideo.service.filter.storage;

import com.minori.svideo.model.request.UserRequest;

public class StorageUserValidator {

    public void validateCommon(UserRequest request) {

    }

    public boolean validateAdd(UserRequest request) {
        validateCommon(request);
        return true;
    }

}
