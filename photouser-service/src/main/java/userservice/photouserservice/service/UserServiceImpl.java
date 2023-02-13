package userservice.photouserservice.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.photouserservice.data.UserEntity;
import userservice.photouserservice.data.UsersRepository;
import userservice.photouserservice.shared.UserDto;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    UsersRepository usersRepository;

    @Autowired
    UserServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDetails,UserEntity.class);

        userEntity.setEncryptedPassword("testpassword");
        usersRepository.save(userEntity);

        return null;
    }
}
