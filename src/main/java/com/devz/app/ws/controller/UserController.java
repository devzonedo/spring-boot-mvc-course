package com.devz.app.ws.controller;

import com.devz.app.ws.model.request.UserDetailRequestModel;
import com.devz.app.ws.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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


    @GetMapping(path = "/{userId}" ,
            produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        UserRest userRest = new UserRest();
        userRest.setEmail("test@mail.com");
        userRest.setFirstName("testName F");
        userRest.setLastName("testName L");
        userRest.setEmail("testEmail");
        return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
        //return "get user was called with user id = "+userId;
    }

    @PostMapping (consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    } ,
    produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailRequestModel userDetail){

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetail.getEmail());
        returnValue.setFirstName(userDetail.getFirstName());
        returnValue.setLastName(userDetail.getLastName());
        return new ResponseEntity<UserRest>(returnValue,HttpStatus.ACCEPTED);
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
