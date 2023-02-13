package userservice.photouserservice.data;

import org.springframework.data.repository.CrudRepository;

public interface UsersInterface extends CrudRepository<UserEntity,Long> {
}
