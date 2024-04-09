package tech.nocountry.classlodge.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCategoryDTO {
    private String name;
    private String description;
    private Integer totalHours;
    private Double price;
    private String thumbnailUrl;
    private Boolean isPublished;
    private Boolean hasCertification;

}
