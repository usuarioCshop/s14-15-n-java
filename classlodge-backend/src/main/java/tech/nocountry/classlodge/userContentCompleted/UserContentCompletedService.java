package tech.nocountry.classlodge.userContentCompleted;

import java.util.List;

public interface UserContentCompletedService {

    List<UserContentCompleted> getAllUserContentCompleted();
    UserContentCompleted getUserContentCompletedById(Integer id);
    void deleteUserContentCompleted(Integer id);
    UserContentCompleted saveUserContentCompleted(UserDTO userDTO);
    UserContentCompleted updateUserContentCompleted(UserContentCompleted existingUserContentCompleted);
    UserContentCompleted getUserContentCompletedByIdAndEmail(Integer id, String email);
}