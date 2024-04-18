package tech.nocountry.classlodge.userContentCompleted;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.nocountry.classlodge.courseContent.CourseContent;
import tech.nocountry.classlodge.user.User;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email", "content_id"})
})
@Entity
public class UserContentCompleted implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@NotBlank(message = "cannot be null or blank")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(length = 50)
    @NotNull(message = "cannot be null")
    @Email(message="invalid")
    private String email;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private User user;

    @Column(name = "content_id")
    private Long contentId;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_marked_as_completed")
    private Date dateMarkedAsCompleted;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "content_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CourseContent courseContent;


}
