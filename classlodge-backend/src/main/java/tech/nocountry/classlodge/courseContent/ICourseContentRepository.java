package tech.nocountry.classlodge.courseContent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseContentRepository extends JpaRepository<CourseContent, Long> {

}
