package tech.nocountry.classlodge.user;

public record UserDetailsDTO(
        String email,
        String firstName,
        String lastName,
        UserRoleEnum role
){}
