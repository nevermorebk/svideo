package com.minori.svideo.service.transformer;

import com.minori.svideo.common.model.User;
import com.minori.svideo.model.request.UserRequest;

public interface UserTransformer {

    User convertToEntity(UserRequest request);

}
