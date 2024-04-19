package tech.nocountry.classlodge.userNotes;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("api/v1/usernote")
@CrossOrigin(origins = "*")
public class UserNoteController {

    private final UserNoteServiceImp userNoteServiceImp;

    @Autowired
    public UserNoteController(UserNoteServiceImp userNoteServiceImp){
        this.userNoteServiceImp = userNoteServiceImp;
    }

    @PostMapping("/usernote")
    @Operation(summary = "Este endpoint crea un nuevo apunte")
    @Transactional
    public ResponseEntity<?> createUserNote(@RequestBody UserNote userNote, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()) {
                StringBuilder errorMessage = new StringBuilder("Validation errors: ");
                for (FieldError error : bindingResult.getFieldErrors()) {
                    errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ");
                }
                return ResponseEntity.badRequest().body(errorMessage.toString());
            }
            if (!this.userNoteServiceImp.exists(userNote.getId())) {
                return ResponseEntity.status(HttpStatus.CREATED).body(this.userNoteServiceImp.createUserNote(userNote));
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("The note already exists");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Unexpect exception creating the note");
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Este endpoint obtiene un apunte por ID")
    public ResponseEntity<UserNoteDTO> getCommentById(@PathVariable Integer id){
        try{
            UserNoteDTO tmp = this.userNoteServiceImp.getUserNoteById(id);
            if(isNull(tmp)){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(tmp);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/list/{courseId}")
    public ResponseEntity<List<UserNoteDTO>> getAllUserNoteById(Integer courseId){
        try {
            return ResponseEntity.ok(this.userNoteServiceImp.getAllUserNoteById(courseId));
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(path="/{id}")
    @Transactional
    public ResponseEntity<?> modifyCourse(@RequestBody UserNoteDTO newUserNote, BindingResult bindingResult, @PathVariable("Id") Integer noteId){
        try {
            if(bindingResult.hasErrors()) {
                StringBuilder errorMessage = new StringBuilder("Validation errors: ");
                for (FieldError error : bindingResult.getFieldErrors()) {
                    errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ");
                }
                return ResponseEntity.badRequest().body(errorMessage.toString());
            }
            if (this.userNoteServiceImp.exists(noteId)) {
                return ResponseEntity.status(HttpStatus.OK).body(this.userNoteServiceImp.modifyUserNote(noteId, newUserNote));
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Unexpect exception modifying the note");
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUserNote(Integer id){
        userNoteServiceImp.deleteUserNote(id);
    }
}
