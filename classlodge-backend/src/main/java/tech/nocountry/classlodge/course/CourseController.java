package tech.nocountry.classlodge.course;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/course")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Operation(summary = "Get list course", description = "Return list course", tags = {"Cursos"})
    @GetMapping
    public ArrayList<Course> getCourse(){

        return this.courseService.getCourse();
    }
    @Operation(summary = "Obtener un curso por ID", description = "Devuelve los detalles de un curso específico", tags = {"Cursos"})
    @ApiResponse(responseCode = "200", description = "Curso encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class)))
    @ApiResponse(responseCode = "404", description = "Curso no encontrado", content = @Content)
    @Parameter(name = "id", description = "ID del curso", required = true, example = "1")
    @GetMapping(path = "/{id}")
    public Course getCourseById(@PathVariable Long id){
        System.out.println(id);
        return courseService.getById(id);
    }

    @Operation(summary = "For creation of the course", description = "Return course", tags = {"Cursos"})
    @PostMapping

     public Course saveCourse(@RequestBody Course course){

        return this.courseService.saveCourse(course);
    }
    @Operation(summary = "Para modificar informacion del Curso", description = "Devuelve usuaruio creado", tags = {"Cursos"})
    @PutMapping(path="/{id}")
    public Course modifyCourse(@RequestBody CourseDTO dto, @PathVariable("id") Long id){

        return courseService.updateById(dto,id);
    }
    //Endpoit para listar todos los cursos por una categoria especifica
    @GetMapping(path = "/categoria/{cat}")
    @Operation(summary = "Obtener un curso de una Categoria Determinada", description = "Devuelve listado con los cursos de una categoria", tags = {"Cursos"})
    @ApiResponse(responseCode = "200", description = "Listado de curso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class)))
    @ApiResponse(responseCode = "404", description = "Sin Curso para esa categoria", content = @Content)
    @Parameter(name = "cat", description = "Categoria a buscar", required = true, example = "PROGRAMACION")

    public List<CourseCategoryDTO> getCourseByCategory(@PathVariable("cat") CategoryEnum category){
            return courseService.categoryAll(category);
    }

    @GetMapping(path = "/categoria/pub/{cat}")
    public List<CourseCategoryDTO> getCourseByCategoryPub(@PathVariable("cat") CategoryEnum category){
        return courseService.categoryAll(category);
    }



}
