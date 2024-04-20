package tech.nocountry.classlodge.userCertifications;

public class UserCertificationMapperDTO {
    public static UserCertificationDTO toUserCertificationDTO(UserCertification userCertification) {
        return new UserCertificationDTO(
                userCertification.getUser().getEmail(),
                userCertification.getCourse().getId(),
                userCertification.getStatus(),
                userCertification.getLastAttemptDate(),
                userCertification.getRemainingAttempts()
        );
    }

    public static UserCertificationPdfDTO toUserCertificationPdfDTO(UserCertification userCertification) {
        return new UserCertificationPdfDTO(
                userCertification.getUser().getEmail(),
                userCertification.getCourse().getId(),
                userCertification.getStatus().name(),
                userCertification.getLastAttemptDate(),
                userCertification.getRemainingAttempts(),
                userCertification.getUser().getFirstName(),
                userCertification.getCourse().getName()
        );
    }
}
