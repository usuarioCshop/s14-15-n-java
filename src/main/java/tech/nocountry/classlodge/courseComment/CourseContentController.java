package tech.nocountry.classlodge.courseComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courseContent")
@CrossOrigin(origins = "*")
public class CourseContentController {
    @Autowired
    CourseContentService courseContentService;
    @GetMapping
    public List<CourseContent> ListCourseContent(){
        return courseContentService.getAllCourseContent();
    }
    @GetMapping(path="/{id}")
    public CourseContent ListCourseContentId(@PathVariable Long id){
        return courseContentService.courseContentId(id);
    }
    @PostMapping
    public CourseContent createCourseContent(@RequestBody CourseContent request){
        return courseContentService.createCourseContent(request);
    }
    @PutMapping(path="/{id}")
    public CourseContent updateCourseContent(@RequestBody CourseContent request,@PathVariable Long id){
        return courseContentService.updateCourseContent(request,id);

    }
    @DeleteMapping(path="/{id}")
    public String deleteCourseContent(@PathVariable Long id){

        if(courseContentService.deleteCourseContent(id)) {
            return "El contenido del curso " + id + " fue borrado exitosamente";
        }else{
           return "Error al borrar contenido";
        }

    }


}
