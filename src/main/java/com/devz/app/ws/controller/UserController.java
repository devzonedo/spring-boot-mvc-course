package com.devz.app.ws.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page") int page,@RequestParam( value = "limit") int limit){
        return "get users was called page = "+page;
    }


    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId){
        return "get user was called with user id = "+userId;
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
