package com.minori.svideo.rest.filter.input;

import com.minori.svideo.model.request.UserRequest;
import org.springframework.util.StringUtils;

public class DataInputUserValidator {

    public void validateCommon(UserRequest request) {

    }

    public boolean validateAdd(UserRequest request) {
        validateCommon(request);
        return true;
    }
}
