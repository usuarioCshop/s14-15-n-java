package tech.nocountry.classlodge.userCertifications;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCertificationDTO{
    @NotNull
    @Email
    String userEmail;
    @NotNull
    Long courseId;
    @Enumerated(EnumType.STRING)
    @NotNull
    Status status;
    @NotNull
    Date lastAttemptDate;
    @NotNull
    @Positive
    Integer remainingAttempts;
}
