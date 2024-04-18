package tech.nocountry.classlodge.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.core.SpringVersion;
import tech.nocountry.classlodge.course.Course;
import tech.nocountry.classlodge.courseContent.CourseContent;
import tech.nocountry.classlodge.user.User;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@NotBlank(message = "cannot be null or blank")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(length = 50)
    @NotNull(message = "cannot be null")
    @Email(message="invalid")
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Type of comment cannot be null")
    @Column(name = "comment_type", nullable = false, length = 25)
    private CommentTypeOfCommentEnum commentType;

    @NotBlank(message = "Comment cannot be null or blank")
    @Size(max = 500, message = "Comment must have maximum 500 characters")
    @Column(name = "comment", nullable = false, length = 500)
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Post date cannot be null")
    @Column(name = "post_date", nullable = false)
    private Date postDate;

    @NotNull(message = "Is published flag cannot be null")
    @Column(name = "is_published", nullable = false)
    private Boolean isPublished;

    @NotNull(message = "Rating awarded cannot be null")
    @Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 5, message = "Rating cannot be more than 5")
    @Column(name = "rating_awarded", nullable = false)
    private Integer ratingAwarded;

    // relacion entre el comentario y el curso
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    // Relacion entre el comentario y el usuario
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private User users;

}