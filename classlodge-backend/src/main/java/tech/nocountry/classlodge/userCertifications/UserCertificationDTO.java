package tech.nocountry.classlodge.userCertifications;

import lombok.Builder;
import tech.nocountry.classlodge.course.Course;
import tech.nocountry.classlodge.user.User;

import java.util.Date;
@Builder
public record UserCertificationDTO(
        Long id,
        User user,
        Course course,
        Status status,
        Date lastAttemptDate,
        Integer remainingAttempts
) {
}
