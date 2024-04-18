package tech.nocountry.classlodge.user;


import java.util.List;

public interface UserService {
    User saveUser(UserSaveDataDTO userSaveDataDTO);

    Boolean exists(String emailUser);

    Boolean existsDNI(String dni);
    UserDetailsDTO getByEmail(String emailUser);

    List<UserDetailsDTO> getAll();

}
