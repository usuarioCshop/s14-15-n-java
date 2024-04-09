package tech.nocountry.classlodge.courseComment;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.nocountry.classlodge.course.CategoryEnum;
import tech.nocountry.classlodge.course.CurrencyEnum;



@Entity
@Table(name="course_content")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 150)
    @NotNull
    private Long courseId;

    @NotNull
    @Positive
    @Column(columnDefinition = "DOUBLE(5,2)")
    private Double contentIndex;

    @Column(nullable = false,length = 1000)
    @NotNull
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false, length = 100)
    private ContentTypeEnum contentType;

    @Column(nullable = false,length = 500)
    @NotNull
    private String url;

    @Column(nullable = false, columnDefinition = "TINYINT")
    @NotNull
    private Boolean admits_taking_notes;

    @Column(nullable = false, columnDefinition = "TINYINT")
    @NotNull
    private Boolean isPublished;



}
