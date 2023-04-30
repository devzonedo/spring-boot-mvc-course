package userservice.photouserservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import userservice.photouserservice.shared.UserDto;

public interface UserService extends UserDetailsService {
    public UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);
}
