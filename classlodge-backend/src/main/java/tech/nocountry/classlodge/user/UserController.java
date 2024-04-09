package tech.nocountry.classlodge.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Returns basic details about all users
    @GetMapping()
    public ResponseEntity<List<UserDetailsDTO>> getAll(){
        try {
            return ResponseEntity.ok(this.userService.getAll());
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    //Returns basic details about an user by email
    @GetMapping("/{emailUser}")
    @Operation(summary = "This endpoint allows the user's basic data to be consulted by email.")
    public ResponseEntity<UserDetailsDTO> getByEmail(@PathVariable("emailUser") String emailUser){
        try{
            UserDetailsDTO tmp=this.userService.getByEmail(emailUser);
            if(isNull(tmp)){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(tmp);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/create")
    @Operation(summary = "This endpoint allows the creation of a user within the database")
    @Transactional
    public ResponseEntity<?> save(@Valid @RequestBody User user, BindingResult bindingResult) {
        try {
            if(bindingResult.hasErrors()) {
                StringBuilder errorMessage = new StringBuilder("Validation errors: ");
                for (FieldError error : bindingResult.getFieldErrors()) {
                    errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ");
                }
                return ResponseEntity.badRequest().body(errorMessage.toString());
            }
            if (!this.userService.exists(user.getEmail())) {
                return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveUser(user));
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This email has been already registered");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Unexpect exception creating user");
        }
    }
}
