package tech.nocountry.classlodge.course;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {
    private final ModelMapper courseMapper;

    @Autowired
    public CourseConverter(ModelMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public Course dtoToEntity(CourseDTO courseDTO, Course course) {
        Course update = courseMapper.map(courseDTO, Course.class);
        update.setTeacherEmail(course.getTeacherEmail());
        return update;
    }
    public CourseCategoryDTO entityToCategoryDTO(Course course){
        return courseMapper.map(course,CourseCategoryDTO.class);
    }

}
