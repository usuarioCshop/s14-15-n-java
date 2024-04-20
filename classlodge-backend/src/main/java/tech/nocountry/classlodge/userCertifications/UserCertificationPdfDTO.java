package tech.nocountry.classlodge.userCertifications;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCertificationPdfDTO {
    private String userEmail;
    private Long courseId;
    private String status;
    private Date lastAttemptDate;
    private int remainingAttempts;
    private String userName;
    private String courseName;

}
