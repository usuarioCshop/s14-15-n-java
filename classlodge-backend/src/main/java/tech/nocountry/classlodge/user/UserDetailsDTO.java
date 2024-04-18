package tech.nocountry.classlodge.user;

public record UserDetailsDTO(
        String fullName,
        String email,
        UserRoleEnum role
){}
