package tech.nocountry.classlodge.course;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    ICourseRepository courseRepository;
    @Autowired
    CourseConverter courseConverter;



    public List<Course> findAll(){
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    public Course save(CourseDTO courseDTO){
        ModelMapper modelMapper = new ModelMapper();
        Course course = modelMapper.map(courseDTO,Course.class);
        course.setCourseContentList(null);
        return courseRepository.save(course);
    }

    public Course getById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> null);
    }


    public Course updateById(CourseDTO request, Long id){
         Course courseExist = getById(id);
        if(courseExist ==null){
            return null;
        }
        Course courseUpdate = courseConverter.dtoToEntity(request,courseExist);
        courseUpdate.setId(id);
        courseRepository.save(courseUpdate);
        return courseUpdate;
    }
    public List<CourseCategoryDTO> categoryAll(CategoryEnum category){
        List<Course> courses = courseRepository.findByCategory(category);
        return courses.stream()
                .map(course -> courseConverter.entityToCategoryDTO(course))
                .collect(Collectors.toList());

    }


    public void delete(Long id) {
            courseRepository.deleteById(id);
    }
}
