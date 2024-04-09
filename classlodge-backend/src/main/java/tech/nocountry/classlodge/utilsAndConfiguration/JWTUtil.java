package tech.nocountry.classlodge.utilsAndConfiguration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JWTUtil {

    //Llave de cifrado
    private static String SECRET_KEY = "Cl1ssL4dg2";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);
    //Metodo para crear al token
    public String create(String userName){
        return JWT.create()
                //Se inyecta el nombre de usuario
                .withSubject(userName)
                .withIssuer("Classlodge")
                //Fecha de creacion del token
                .withIssuedAt(new Date())
                //Se establece la duracion del token en 15 dias desde su creacion
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(15)))
                .sign(ALGORITHM);
    }

    //Validar si el token es valido
    public boolean isValid(String jwt){
        try{
            JWT.require(ALGORITHM)
                    .build()
                    .verify(jwt);
            return true;
        } catch (JWTVerificationException e){
            return false;
        }
    }

    //Verificar que el usuario en el token sea el correcto
    public String getEmail(String jwt){
        return JWT.require(ALGORITHM)
                .build()
                .verify(jwt)
                .getSubject();
    }

}
