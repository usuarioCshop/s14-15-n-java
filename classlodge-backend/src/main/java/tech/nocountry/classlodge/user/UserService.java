package tech.nocountry.classlodge.user;


import java.util.List;

public interface UserService {
    User saveUser(User user);

    Boolean exists(String emailUser);
    UserDetailsDTO getByEmail(String emailUser);

    List<UserDetailsDTO> getAll();

}
