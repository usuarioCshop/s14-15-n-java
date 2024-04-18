package tech.nocountry.classlodge.userNotes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record UserNoteDTO (
        @Length(max = 500) @NotBlank String details,
        @Length(max = 1000) @NotBlank String noteContent,
        @NotNull Date dateTaken,
        @NotNull Boolean modified
){}
