package tech.nocountry.classlodge.userCertifications;

import java.util.List;

public interface UserCertificationService {
    List<UserCertificationDTO> findByUserEmail(String userEmail);
    List<UserCertificationDTO> findByUserEmailAndCourseId(String userEmail, Long courseId);
    UserCertificationDTO createCertification(UserCertificationDTO userCertificationDTO);
    UserCertificationDTO updateCertification(Long id,UserCertificationDTO userCertificationDTO);
    void deleteAllCertifications(String userEmail);
    void deleteByUserEmailAndCourseId(String userEmail, Long courseId);
    byte[] generatePDF(UserCertificationPdfDTO dto);
    UserCertificationPdfDTO getCertificationById(Long certificationId) throws Exception;
}
