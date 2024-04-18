package tech.nocountry.classlodge.userContentCompleted;

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
import tech.nocountry.classlodge.user.User;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("api/v1/userContentCompleted")
@CrossOrigin(origins = "*")

public class UserContentCompletedController {

    private final UserContentCompletedServiceImpl userContentCompletedService;

    @Autowired
    public UserContentCompletedController(UserContentCompletedServiceImpl userContentCompletedService) {
        this.userContentCompletedService = userContentCompletedService;
    }

    @GetMapping
    @Operation(summary = "This endpoint retrieve a list of details of UserContentCompleted")
    public ResponseEntity<List<UserContentCompleted>> getAllUserContentCompleted() {
        List<UserContentCompleted> userContentCompletedList = userContentCompletedService.getAllUserContentCompleted();
        return ResponseEntity.ok(userContentCompletedList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "This endpoint get one details of UserContentCompleted by Id")
    public ResponseEntity<UserContentCompleted> getUserContentCompletedById(@PathVariable Integer id) {
        UserContentCompleted userContentCompleted = userContentCompletedService.getUserContentCompletedById(id);
        if (userContentCompleted != null) {
            return ResponseEntity.ok(userContentCompleted);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserContentCompleted> saveUserContentCompleted(@RequestBody UserDTO userDTO) {
        UserContentCompleted savedUserContentCompleted = userContentCompletedService.saveUserContentCompleted(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserContentCompleted);
    }

    @PutMapping("/{id}")
    @Operation(summary = "This endpoint allows to update the date in a userContentCompleted by id")
    public ResponseEntity<UserContentCompleted> updateUserContentCompleted(@PathVariable Integer id, String email) {
//        Optional<UserContentCompleted> existingUserContentCompletedOptional = Optional.ofNullable(userContentCompletedService.getUserContentCompletedByIdAndEmail(id, email));
//        if (existingUserContentCompletedOptional.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
        UserContentCompleted existingUserContentCompleted = userContentCompletedService.getUserContentCompletedByIdAndEmail(id, email);
        //UserContentCompleted existingUserContentCompleted = existingUserContentCompletedOptional.get();
        UserContentCompleted updatedUserContentCompleted = userContentCompletedService.updateUserContentCompleted(existingUserContentCompleted);
        return ResponseEntity.ok(updatedUserContentCompleted);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserContentCompleted(@PathVariable Integer id) {
        userContentCompletedService.deleteUserContentCompleted(id);
        return ResponseEntity.noContent().build();
    }

}