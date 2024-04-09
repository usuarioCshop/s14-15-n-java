package tech.nocountry.classlodge.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.nocountry.classlodge.user.User;

@Service
public class UserAuthSecurityService implements UserDetailsService {
    //Se implementa la interface UserDetailsService para que Sring sepa que este es el
    //servicio para autorizar los usuarios y realizar el enlace de la entidad User de Spring
    //con el registro correspondient de la tabla de users

    //Inyeccion del repositorio de autoridad
    private final UserAuthRepository userAuthRepository;


   //instanciacion del repositorio de usuario
    @Autowired
    public UserAuthSecurityService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }


    @Override
    //Aqui se mapea el usuario USER de spring con su correcpondiente registro de la tabla users de la BD
    public UserDetails loadUserByUsername(String emailuser) throws UsernameNotFoundException {
        User user = this.userAuthRepository.findById(emailuser)
                .orElseThrow(() -> new UsernameNotFoundException("User " + emailuser + " not found"));


        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().toString())
                .accountLocked(user.getLocked())
                .disabled(user.getDisabled())
                .accountExpired(user.getExpired())
                .build();
    }
}
