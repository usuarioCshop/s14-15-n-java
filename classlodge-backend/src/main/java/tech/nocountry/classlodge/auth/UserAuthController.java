package tech.nocountry.classlodge.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import tech.nocountry.classlodge.user.User;
import tech.nocountry.classlodge.user.UserDetailsDTO;
import tech.nocountry.classlodge.user.UserService;
import tech.nocountry.classlodge.utilsAndConfiguration.JWTUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/auth")
public class UserAuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JWTUtil jwtUtil;

    @Autowired
    public UserAuthController(AuthenticationManager authenticationManager, UserService userService, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;

    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.emailUser(), loginDto.password());
        Authentication authentication = this.authenticationManager.authenticate(login);

        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());

        UserDetailsDTO usuario =  this.userService.getByEmail(loginDto.emailUser());
        String jwt = jwtUtil.create(loginDto.emailUser(), usuario.fullName(), usuario.role().name().toUpperCase());
        Map<String, String> response = new HashMap<>();
        response.put("token", jwt); // Agregamos el token al mapa de respuesta
        //return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwt).build();  //retornamos el token en el header
        return ResponseEntity.ok().body(response); //retornamos el token en el body

    }

}
