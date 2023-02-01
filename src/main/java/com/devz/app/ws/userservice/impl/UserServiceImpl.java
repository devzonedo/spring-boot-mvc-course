package com.devz.app.ws.userservice.impl;

import com.devz.app.ws.model.request.UserDetailRequestModel;
import com.devz.app.ws.model.response.UserRest;
import com.devz.app.ws.userservice.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;


    @Override
    public UserRest createUser(UserDetailRequestModel userDetail) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetail.getEmail());
        returnValue.setFirstName(userDetail.getFirstName());
        returnValue.setLastName(userDetail.getLastName());

        if (users == null) users = new HashMap<>();
        String userid = UUID.randomUUID().toString();
        returnValue.setUserId(userid);

        users.put(userid,returnValue);

        return returnValue;
    }
}
