package tech.nocountry.classlodge.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Bean;

public record UserSaveDataDTO(
        @NotNull @NotBlank String fullName,
        @Email @NotNull @NotBlank String email,
        @Length(min = 8) @NotBlank String password,
        @NotNull String role
) {}
