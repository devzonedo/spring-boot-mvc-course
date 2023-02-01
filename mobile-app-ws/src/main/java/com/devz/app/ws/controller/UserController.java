package com.devz.app.ws.controller;

import com.devz.app.ws.exception.UserServiceException;
import com.devz.app.ws.model.request.UpdateUserDetailRequestModel;
import com.devz.app.ws.model.request.UserDetailRequestModel;
import com.devz.app.ws.model.response.UserRest;
import com.devz.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

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

if(true)throw new UserServiceException("User service exception is thrown");

        String userName = null;
        int lengthOfUsername = userName.length();

        if(users.containsKey(userId)){
            return new ResponseEntity<UserRest>(users.get(userId),HttpStatus.OK);
        }else{
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
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
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userDetail){

        UserRest returnValue=  userService.createUser(userDetail);

        return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
    }

    @PutMapping( path = "/{userId}", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    } ,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public UserRest updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailRequestModel userDetail){

        UserRest storedUserDetails =  users.get(userId);
        storedUserDetails.setFirstName(userDetail.getFirstName());
        storedUserDetails.setLastName(userDetail.getLastName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}",  consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    } ,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }

}
