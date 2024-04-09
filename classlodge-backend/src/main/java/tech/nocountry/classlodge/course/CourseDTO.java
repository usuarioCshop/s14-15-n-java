package tech.nocountry.classlodge.course;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private String name;
    private String description;
    private Integer totalHours;
    private Double price;
    private CurrencyEnum currency;
    private CategoryEnum category;
    private String thumbnailUrl;
    private Boolean isPublished;
    private Boolean hasCertification;

}
