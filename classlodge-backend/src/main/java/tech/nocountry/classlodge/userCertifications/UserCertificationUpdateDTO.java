package tech.nocountry.classlodge.userCertifications;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCertificationUpdateDTO{
    @NotNull
    @Enumerated(EnumType.STRING)
    Status status;
    @NotNull
    Date lastAttemptDate;
    @NotNull
    Integer remainingAttempts;
}
