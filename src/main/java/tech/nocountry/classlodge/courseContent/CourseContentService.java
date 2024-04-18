package tech.nocountry.classlodge.courseContent;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.nocountry.classlodge.course.Course;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseContentService {
    @Autowired
    private ICourseContentRepository courseContentRepository;

    public CourseContent courseContentId(Long id){
        Optional<CourseContent> content = courseContentRepository.findById(id);

        if(content.isPresent()){
            return content.get();
        }else{
            return null;
        }

    }
    public CourseContent save(ContentPostDTO request){
        ModelMapper modelMapper = new ModelMapper();
        CourseContent courseContent = modelMapper.map(request,CourseContent.class);
        return courseContentRepository.save(courseContent);
    }

    public boolean deleteCourseContent(Long id){
        try {
            courseContentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public CourseContent updateCourseContent(ContentPostDTO newContent, Long id) {
        ModelMapper modelMapper = new ModelMapper();
        CourseContent existingContent = courseContentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CourseContent not found with id: " + id));
        //mapeo la clase newContent del Tipo ContentPostDTO a la clase CourseContent para
        //persistir en la entidad de la bd
        CourseContent content = modelMapper.map(newContent,CourseContent.class);
        System.out.println(newContent.getCourseId());

        return courseContentRepository.save(content);
    }

}
