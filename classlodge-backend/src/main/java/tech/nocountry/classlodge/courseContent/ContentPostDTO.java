package tech.nocountry.classlodge.courseContent;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentPostDTO {
    //private Long id;
    @NotBlank(message = "required course id")
    @Positive
    private Long courseId;
    @NotBlank(message = "contentIndex is number for order the material of study")
    @Positive
    private Double contentIndex;
    @NotBlank
    @Size(min=5,max=500,message = "required between 5 and 500 characters ")
    private String description;
    private ContentTypeEnum contentType;
    private String url;
    private Boolean admitsTakingNotes;
    private Boolean isPublished;
}
