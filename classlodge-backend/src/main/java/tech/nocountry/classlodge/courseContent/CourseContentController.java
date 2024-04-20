package tech.nocountry.classlodge.courseContent;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courseContent")
@CrossOrigin(origins = "*")
public class  CourseContentController {
    @Autowired
    CourseContentService courseContentService;


    @Operation(summary = "Devuelve un recurso especifico",tags={"Contenido"})
    @GetMapping(path="/{id}")
    public ResponseEntity<?> courseContentById(@PathVariable("id") Long id){
               CourseContent course= courseContentService.courseContentId(id);
        if(course ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not content");
        }
        return ResponseEntity.ok(course);
    }

    @Operation(summary = "Crear un recurso de contenido para un curso especifico",
            description = "Crea contenido para un curso específico", tags = {"Contenido"})
    @ApiResponse(responseCode = "200", description = "Recurso Encontrado",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = CourseContent.class)))
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content)
     @PostMapping()
    public ResponseEntity<?> createCourseContent(@Valid
                                                 @RequestBody ContentPostDTO request,BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors()){
                return ResponseEntity.badRequest().body(bindingResult.getFieldError());
            }
            CourseContent contenido = courseContentService.save(request);
            if(contenido==null){
                return ResponseEntity.badRequest().body("not save course");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(contenido);
        }catch(Exception e) {
            throw new IllegalArgumentException("Unexpect exception creating user");

        }
    }
    @Operation(summary = "Actualiza un recurso especifico",tags={"Contenido"})
    @PutMapping(path="/{id}")
    public ResponseEntity<?> updateCourseContent(
            @Valid BindingResult bindingResult,
            @RequestBody ContentPostDTO request,
            @PathVariable("id") Long id){
        try {
            if(bindingResult.hasErrors()){
                return ResponseEntity.badRequest().body(bindingResult.getFieldError());
            }
            CourseContent content = courseContentService.updateCourseContent(request,id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Updte success");
        }catch(Exception e){
            throw new IllegalArgumentException("Unexpect exception creating user");
        }

    }
    @Operation(summary = "Elimina un recurso especifico",tags={"Contenido"})
    //Listo
    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteCourseContent(@PathVariable Long id){
        try{
        if(courseContentService.deleteCourseContent(id)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("El contenido del curso " + id + " fue borrado exitosamente");
        }else{
           return ResponseEntity.badRequest().body("Error al borrar contenido");
        }
        }catch (Exception e){
            throw new IllegalArgumentException("Unexpect exception creating user");
        }

    }


}
