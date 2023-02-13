package userservice.photouserservice.service;

import userservice.photouserservice.shared.UserDto;

public interface UserService {
    public UserDto createUser(UserDto userDetails);
}
