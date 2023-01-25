package com.devz.app.ws.controller;

import com.devz.app.ws.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page" , defaultValue = "4") int page,
                           @RequestParam( value = "limit") int limit,
                           @RequestParam( value = "sort" , required = false) String sort){
        return "get users was called page = "+page;
    }


    @GetMapping(path = "/{userId}")
    public UserRest getUser(@PathVariable String userId){
        UserRest userRest = new UserRest();
        userRest.setEmail("test@mail.com");
        userRest.setFirstName("testName F");
        userRest.setLastName("testName L");
        userRest.setEmail("testEmail");
        return userRest;
        //return "get user was called with user id = "+userId;
    }

    @PostMapping
    public String createUser(){
        return "create user was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }

}
