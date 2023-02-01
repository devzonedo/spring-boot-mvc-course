package com.devz.app.ws.userservice;

import com.devz.app.ws.model.request.UserDetailRequestModel;
import com.devz.app.ws.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailRequestModel userDetails);
}
