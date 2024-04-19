package tech.nocountry.classlodge.courseContent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.nocountry.classlodge.course.CategoryEnum;
import tech.nocountry.classlodge.course.Course;
import tech.nocountry.classlodge.course.CurrencyEnum;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseContentDTO {
    private String name;
    private Course curse;
    private String description;
    private Integer totalHours;
    private Double price;
    private CurrencyEnum currency;
    private CategoryEnum category;
    private String thumbnailUrl;
    private Boolean isPublished;
    private Boolean hasCertification;

}

