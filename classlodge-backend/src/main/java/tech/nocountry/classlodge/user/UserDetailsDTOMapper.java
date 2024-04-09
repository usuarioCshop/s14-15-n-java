package tech.nocountry.classlodge.user;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDetailsDTOMapper implements Function<User, UserDetailsDTO> {
    @Override
    public UserDetailsDTO apply(User user) {
        return new UserDetailsDTO(
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole()
        );
    }
}
