package tech.nocountry.classlodge.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementacion de la interface de servicio de la entidad usuario
 *
 * @author Gonzalo and Raul
 *
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsDTOMapper userDetailsDTOMapper;

    @Autowired  
    public UserServiceImpl(UserRepository userRepository, UserDetailsDTOMapper userDetailsDTOMapper) {
        this.userRepository = userRepository;
        this.userDetailsDTOMapper = userDetailsDTOMapper;
    }


    /**
     * Crea un codificador para BCrypt
     * @return Codificador
     */
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Guarda un objeto user en la tabla user de la BD
     * previamente se encripta el password
     *
     * @param user
     * @return User
     */
    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Verifica si el usuario existe en la BD mediante el email
     *
     * @param emailUser
     * @return Boolean
     */
    @Override
    public Boolean exists(String emailUser) {
        return this.userRepository.existsById(emailUser);
    }

    @Override
    /**
     * Retorna los detalles basicos de un usuario por su mail
     * @return UserDetailsDTO
     */
    public UserDetailsDTO getByEmail(String emailUser) {
        return this.userRepository.findById(emailUser).map(userDetailsDTOMapper).orElse(null);
    }

    /**
     * Retorna la lista de todos los usuarios registrados en la BD
     * Detalles reornados segun el DTO UserDetailsDTO
     * @return List<UserDetailsDTO>
     */
    @Override
    public List<UserDetailsDTO> getAll() {
        return this.userRepository.findAll().stream().map(userDetailsDTOMapper).collect(Collectors.toList());
    }
}
