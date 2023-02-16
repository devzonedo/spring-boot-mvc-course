package userservice.photouserservice.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.photouserservice.data.UserEntity;
import userservice.photouserservice.model.CreateUserRequestModel;
import userservice.photouserservice.model.CreateUserResponseModel;
import userservice.photouserservice.service.UserService;
import userservice.photouserservice.shared.UserDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private Environment env;

    @Autowired
    UserService userService;

    @GetMapping("/status/check")
    public String status(){
        return  "working on port "+env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto  = modelMapper.map(userDetails,UserDto.class);

        UserDto createdUser = userService.createUser(userDto);
        CreateUserResponseModel createUserResponseModel = modelMapper.map(createdUser,CreateUserResponseModel.class);

        return  ResponseEntity.status(HttpStatus.CREATED).body(createUserResponseModel);
    }
}
