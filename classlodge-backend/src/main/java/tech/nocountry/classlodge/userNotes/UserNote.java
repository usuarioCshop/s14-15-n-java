package tech.nocountry.classlodge.userNotes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import tech.nocountry.classlodge.courseContent.CourseContent;
import tech.nocountry.classlodge.user.User;

import java.util.Date;

/**
 *
 * @author Angelina
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_notes")
@Entity
public class UserNote {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id; // PK de la tabla UserNotes

    @Column(nullable = false, length = 500)
    @Size(max = 500)
    private String details;
    @Column(nullable = false, length = 1000)
    @NotNull
    @Size(max = 1000)
    private String noteContent;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
    @Column(nullable = false)
    private Boolean modified = false;

    // Lo pensé como que un apunte solo puede estar asociado a un curso
    @ManyToOne
    @NotNull
    @JoinColumn(name = "course_content_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CourseContent contentId;

    // y varios apuntes se pueden asociar a un alumno.
    @ManyToOne
    @NotNull
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private User users;

}
