package tech.nocountry.classlodge.course;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCategoryDTO {
    @NotBlank(message = "name of de course is required")
    @Size(min = 5, max = 50, message = "must have between 5 and 50 characters")
    private String name;
    @NotBlank(message = "email register is required")
    @Email
    private String description;
    @NotNull
    @Positive
    private Integer totalHours;
    @NotNull
    @Positive
    @Column(columnDefinition = "DOUBLE(6,2)")
    private Double price;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false, length = 50)
    private String thumbnailUrl;
    private Boolean isPublished;
    private Boolean hasCertification;

}
