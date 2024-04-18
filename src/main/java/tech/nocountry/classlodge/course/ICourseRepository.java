package tech.nocountry.classlodge.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByCategory(CategoryEnum category);


}
