package tech.nocountry.classlodge.courseContent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.nocountry.classlodge.course.CategoryEnum;
import tech.nocountry.classlodge.course.Course;
import tech.nocountry.classlodge.course.CurrencyEnum;
import tech.nocountry.classlodge.userContentCompleted.UserContentCompleted;
import tech.nocountry.classlodge.userNotes.UserNote;

import java.util.List;


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

    @Column(insertable=false,updatable = false)
    private Long courseId;
    @ManyToOne
    @JoinColumn(name="courseId")
    @JsonIgnore
    private Course course;


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
    private Boolean admitsTakingNotes;

    @Column(nullable = false, columnDefinition = "TINYINT")
    @NotNull
    private Boolean isPublished;

    @OneToMany(mappedBy = "contentId")
    private List<UserNote> userNote;

    @OneToOne(mappedBy = "courseContent")
    private UserContentCompleted idContentCompleted;

}
