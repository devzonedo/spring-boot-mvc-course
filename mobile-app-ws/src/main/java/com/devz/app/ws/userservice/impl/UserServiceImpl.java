package com.devz.app.ws.userservice.impl;

import com.devz.app.ws.model.request.UserDetailRequestModel;
import com.devz.app.ws.model.response.UserRest;
import com.devz.app.ws.shared.Util;
import com.devz.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Util util;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Util utils) {
        this.util = utils;
    }

    @Override
    public UserRest createUser(UserDetailRequestModel userDetail) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetail.getEmail());
        returnValue.setFirstName(userDetail.getFirstName());
        returnValue.setLastName(userDetail.getLastName());

        if (users == null) users = new HashMap<>();
        String userid = util.getGeneratedUserId();
        returnValue.setUserId(userid);

        users.put(userid,returnValue);

        return returnValue;
    }
}
