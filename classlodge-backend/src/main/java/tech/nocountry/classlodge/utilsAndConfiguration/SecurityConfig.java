package tech.nocountry.classlodge.utilsAndConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JWTFilter jwtFilter;

    @Autowired
    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(customizeRequests -> {
                            customizeRequests
                                    .requestMatchers("doc/swagger-ui/**", "/v3/api-docs/**", "doc/swagger-resources/**").permitAll()
                                    //User and login
                                    .requestMatchers(HttpMethod.POST,"/api/v1/auth/login").permitAll()
                                    .requestMatchers(HttpMethod.POST,"/api/v1/user/create").permitAll()
                                    .requestMatchers(HttpMethod.GET,"/api/v1/user/{emailUser}").hasAnyRole("ADMIN", "TEACHER", "STUDENT")
                                    .requestMatchers(HttpMethod.GET,"/api/v1/user").hasAnyRole("ADMIN", "TEACHER")
                                    //Courses
                                    .requestMatchers(HttpMethod.GET,"/api/v1/course/categoria/{cat}").permitAll() //Permite solicitudes a anonimos y autenticados
                                    .requestMatchers(HttpMethod.GET,"/api/v1/course/{id}").permitAll()
                                    .requestMatchers(HttpMethod.GET,"/api/v1/course/list").permitAll()

                                    .requestMatchers(HttpMethod.POST,"/api/v1/course/**").hasAnyRole("TEACHER","ADMIN")
                                    .requestMatchers(HttpMethod.PUT,"/api/v1/course/**").hasAnyRole("ADMIN", "TEACHER")
                                    .requestMatchers(HttpMethod.DELETE,"/api/v1/course/**").hasAnyRole("ADMIN", "TEACHER")

                                     //Course Content
                                    .requestMatchers(HttpMethod.GET,"/api/v1/courseContent/**").hasAnyRole("TEACHER","STUDENT","ADMIN")
                                    .requestMatchers(HttpMethod.PUT,"/api/v1/courseContent/**").hasAnyRole("TEACHER")
                                    .requestMatchers(HttpMethod.POST,"/api/v1/courseContent/**").hasAnyRole("TEACHER")
                                    .requestMatchers(HttpMethod.DELETE,"/api/v1/courseContent/**").hasAnyRole("TEACHER")
                                    //User Notes
                                    .requestMatchers(HttpMethod.POST,"/api/v1/usernotes/**").hasAnyRole("STUDENT")
                                    .requestMatchers(HttpMethod.GET,"/api/v1/usernotes/**").hasAnyRole("STUDENT")
                                    .requestMatchers(HttpMethod.PUT,"/api/v1/usernotes/**").hasAnyRole("STUDENT")
                                    .requestMatchers(HttpMethod.DELETE,"/api/v1/usernotes/**").hasAnyRole("STUDENT")
                                    // Comments
                                    .requestMatchers(HttpMethod.GET,"/api/v1/comment/**").hasAnyRole("ADMIN", "STUDENT")
                                    .requestMatchers(HttpMethod.POST,"/api/v1/comment/**").hasAnyRole("ADMIN", "STUDENT", "TEACHER")
                                    .requestMatchers(HttpMethod.DELETE,"/api/v1/comment/**").hasAnyRole("ADMIN", "STUDENT", "TEACHER")
                                    .requestMatchers(HttpMethod.PUT,"/api/v1/comment/**").hasAnyRole("ADMIN", "STUDENT", "TEACHER")
                                    //Certifications
                                    .requestMatchers(HttpMethod.POST,"/api/v1/certifications/**").hasAnyRole("STUDENT", "TEACHER")
                                    .requestMatchers(HttpMethod.GET,"/api/v1/certifications/**").hasAnyRole("STUDENT", "TEACHER")
                                    .requestMatchers(HttpMethod.PUT,"/api/v1/certifications/**").hasAnyRole("STUDENT", "TEACHER")
                                    .requestMatchers(HttpMethod.DELETE,"/api/v1/certifications/**").hasAnyRole("STUDENT", "TEACHER")
                                    // User Content Completed
                                    .requestMatchers(HttpMethod.GET,"/api/v1/userContentCompleted/**").permitAll()
                                    .requestMatchers(HttpMethod.POST,"/api/v1/userContentCompleted/**").permitAll()
                                    .requestMatchers(HttpMethod.PUT,"/api/v1/userContentCompleted/**").permitAll()
                                    .requestMatchers(HttpMethod.DELETE,"/api/v1/userContentCompleted/**").permitAll()
                                    //Globals
                                    .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.PATCH).hasRole("ADMIN")
                                    .anyRequest()
                                    .authenticated();
                        }
                )
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}

