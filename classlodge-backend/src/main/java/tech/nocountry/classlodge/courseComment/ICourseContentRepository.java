package tech.nocountry.classlodge.courseComment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseContentRepository extends JpaRepository<CourseContent, Long> {

}
