package tech.nocountry.classlodge.user;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.ZoneId;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
    private final UserSaveDataDTOMapper userSaveDataDTOMapper;

    @Autowired  
    public UserServiceImpl(UserRepository userRepository,
                           UserDetailsDTOMapper userDetailsDTOMapper,
                           UserSaveDataDTOMapper userSaveDataDTOMapper) {
        this.userRepository = userRepository;
        this.userDetailsDTOMapper = userDetailsDTOMapper;
        this.userSaveDataDTOMapper = userSaveDataDTOMapper;
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
     * @param userSaveDataDTO
     * @return User
     *
     * TEST:
     * Funciones a probar:
     *    - Si se envia un objeto nulo, se retorna un error?
     *    - Si falta algun nombre/valor del JSON se retorna un error?
     *    -
     */
    @Override
    public User saveUser(UserSaveDataDTO userSaveDataDTO) {
        try {
            User user = new User();
            user.setPassword(passwordEncoder().encode(userSaveDataDTO.password()));
            user.setEmail(userSaveDataDTO.email());
            user.setDni("12345");
            Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
            user.setDob(date);
            user.setExpired(false);
            user.setDisabled(false);
            user.setLocked(false);
            user.setFirstName(userSaveDataDTO.fullName());
            user.setLastName("No data");
            user.setRole(UserRoleEnum.valueOf(userSaveDataDTO.role().toUpperCase()));
            user.setIntroductionText("No data");
            user.setPhotoUrl(new java.net.URL("https://dumy.org/dumy.jpg"));
            user.setProfessionalDegree("No data");
            user.setSex(UserSexEnum.valueOf("PREFERS_NOT_SAY"));
            return userRepository.save(user);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
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
    public Boolean existsDNI(String dni) {
        return this.userRepository.existsByDniIs(dni);
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
