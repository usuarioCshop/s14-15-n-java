package tech.nocountry.classlodge.user;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserSaveDataDTOMapper implements Function<User, UserSaveDataDTO> {

    @Override
    public UserSaveDataDTO apply(User user) {
        return new UserSaveDataDTO(
                user.getFirstName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().name()
        );
    }

}
