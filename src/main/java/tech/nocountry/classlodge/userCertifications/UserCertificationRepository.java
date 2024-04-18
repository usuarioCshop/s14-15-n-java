package tech.nocountry.classlodge.userCertifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCertificationRepository extends JpaRepository<UserCertification, Long> {
    UserCertification findByUserEmailAndCourseId(String userEmail, Long courseId);
    List<UserCertification> findByUserEmail(String userEmail);
    List<UserCertification> findByCourseId(Long courseId);
    UserCertification findByUserEmailAndCourseIdAndStatus(String userEmail,Long courseId, Status status);
    void deleteByUserEmailAndCourseId(String userEmail, Long courseId);
    List<UserCertification> findByUserEmailAndStatus(String userEmail, Status status);
    List<UserCertification> findByCourseIdAndStatus(Long courseId, Status status);
}
