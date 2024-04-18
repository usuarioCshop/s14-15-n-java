package tech.nocountry.classlodge.courseContent;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentDTO {
        @NotNull
        @Size(min = 5, max=150,message="Debe contener entre 5 y 150 caracteres")
        @NotBlank(message = "No puede estar vacio")
        private String description;

        private ContentTypeEnum contentType;
        @NotBlank(message = "cannot be null or blank")
        @Size(min = 5, max = 500, message = "must have between 5 and 500 characters")
        private String url;
        private Boolean admitsTakingNotes;


}
