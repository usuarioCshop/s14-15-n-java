package tech.nocountry.classlodge.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.nocountry.classlodge.user.User;

@Repository
public interface UserAuthRepository extends CrudRepository<User, String> {
}
