package tech.nocountry.classlodge.courseComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseContentService {
    @Autowired
    private ICourseContentRepository courseContentRepository;

    public CourseContent courseContentId(Long id){
        return courseContentRepository.findById(id) .orElseThrow(()->null);
    }
    public CourseContent createCourseContent(CourseContent content){
        return courseContentRepository.save(content);
    }
    public List<CourseContent> getAllCourseContent(){
        return courseContentRepository.findAll();
    }
    public boolean deleteCourseContent(Long id){
        try {
            courseContentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public CourseContent updateCourseContent(CourseContent newContent, Long id) {
        CourseContent existingContent = courseContentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CourseContent not found with id: " + id));

        existingContent.setCourseId(newContent.getCourseId() != 0 ? newContent.getCourseId() : existingContent.getCourseId());
        existingContent.setContentIndex(newContent.getContentIndex() != 0 ? newContent.getContentIndex() : existingContent.getContentIndex());
        existingContent.setDescription(newContent.getDescription().isBlank() ? existingContent.getDescription() : newContent.getDescription());
        existingContent.setContentType(newContent.getContentType() != null ? newContent.getContentType() : existingContent.getContentType());
        existingContent.setUrl(newContent.getUrl().isBlank() ? existingContent.getUrl() : newContent.getUrl());
        existingContent.setAdmits_taking_notes(newContent.getAdmits_taking_notes());
        existingContent.setIsPublished(newContent.getIsPublished());

        return courseContentRepository.save(existingContent);
    }

}
