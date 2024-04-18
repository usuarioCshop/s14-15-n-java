package tech.nocountry.classlodge.userCertifications;

public class UserCertificationMapperDTO {
    public static UserCertificationDTO toUserCertificationDTO(UserCertification userCertification) {
        return new UserCertificationDTO(
                userCertification.getId(),
                userCertification.getUser(),
                userCertification.getCourse(),
                userCertification.getStatus(),
                userCertification.getLastAttemptDate(),
                userCertification.getRemainingAttempts()
        );
    }

    public static UserCertification toUserCertification(UserCertificationDTO userCertificationDTO) {
        UserCertification userCertification = new UserCertification();
        userCertification.setUser(userCertificationDTO.user());
        userCertification.setCourse(userCertificationDTO.course());
        userCertification.setStatus(userCertificationDTO.status());
        userCertification.setLastAttemptDate(userCertificationDTO.lastAttemptDate());
        userCertification.setRemainingAttempts(userCertificationDTO.remainingAttempts());
        return userCertification;
    }
}
