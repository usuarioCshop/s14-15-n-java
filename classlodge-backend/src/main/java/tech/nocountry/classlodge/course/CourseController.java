package tech.nocountry.classlodge.course;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Operation(summary = "Obtiene una lista de Cursos", description = "Obtiene una lista de Cursos", tags = {"Cursos"})

    @GetMapping(path="/list")
    public ResponseEntity<?> getCourse()
    {   List<Course> courseList = courseService.findAll();
        if(courseList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sin Continido para mostrar");
        }
        return ResponseEntity.ok(courseList);
    }

    @Operation(summary = "Permite crear un curso", description = "Devuelve un curso", tags = {"Cursos"})
    @PostMapping(path="/post")
     public ResponseEntity<?> saveCourse(@Valid @RequestBody CourseDTO courseDTO, BindingResult bindingResult){
       try{
           if(bindingResult.hasErrors()){
               return ResponseEntity.badRequest().body(bindingResult.getFieldError());
           }
           Course course = courseService.save(courseDTO);
           return ResponseEntity.ok(course);
       } catch (DataIntegrityViolationException e) {
           return ResponseEntity.status(HttpStatus.CONFLICT).body("El recurso ya existe");

       }catch(Exception e){
           System.out.println(e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
       }

    }

    @Operation(summary = "Obtener un curso por ID", description = "Devuelve los detalles de un curso específico", tags = {"Cursos"})
    @ApiResponse(responseCode = "200", description = "Curso encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class)))
    @ApiResponse(responseCode = "404", description = "Curso no encontrado", content = @Content)
    @Parameter(name = "id", description = "ID del curso", required = true, example = "1")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id){
          Course course = courseService.getById(id);
        if(course == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sin Datos para mostrar");
        }
        return ResponseEntity.ok(course);
    }


    @Operation(summary = "Para modificar informacion del Curso", description = "Devuelve usuaruio creado", tags = {"Cursos"})
    @PutMapping(path="/{id}")
    public ResponseEntity<?> modifyCourse(@Valid
                                               @RequestBody CourseDTO dto,
                                               @PathVariable("id") Long id, BindingResult bindingResult){
           try{
               if(bindingResult.hasErrors()){
                      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldError());
               }
               Course course = courseService.updateById(dto,id);
               return ResponseEntity.ok(course);
           }catch (Exception e){
               System.out.println(e.getMessage());
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
           }

    }
    /*********************************************/
    @Operation(summary = "Permite habilitar/deshabilitar cursos", description = "Para inhabilitar un curso", tags = {"Cursos"})
    @PutMapping(path="/enable/{id}")
    public ResponseEntity<?> deshabilitaCourse(@PathVariable("id") Long id){
        try{
            Course course = courseService.getById(id);
            course = courseService.enableCourse(course);
            return ResponseEntity.ok(course);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }
    //Endpoit para listar todos los cursos por una categoria especifica
    @GetMapping(path = "/categoria/{cat}")
    @Operation(summary = "Obtener un curso de una Categoria Determinada", description = "Devuelve listado con los cursos de una categoria", tags = {"Cursos"})
    @ApiResponse(responseCode = "200", description = "Listado de curso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class)))
    @ApiResponse(responseCode = "404", description = "Sin Curso para esa categoria", content = @Content)
    @Parameter(name = "cat", description = "Categoria a buscar", required = true, example = "PROGRAMACION")

    public ResponseEntity<List<CourseCategoryDTO>> getCourseByCategory(@PathVariable("cat") CategoryEnum category){
        List<CourseCategoryDTO> courseCategoryDTOList = courseService.categoryAll(category);
        return ResponseEntity.ok(courseCategoryDTOList);
    }



}
