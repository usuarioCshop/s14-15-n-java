package tech.nocountry.classlodge.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import tech.nocountry.classlodge.comment.Comment;
import tech.nocountry.classlodge.userContentCompleted.UserContentCompleted;
import tech.nocountry.classlodge.userNotes.UserNote;

import java.net.URL;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    @Column(length = 50)
    @NotBlank(message = "cannot be null or blank")
    @Size(min = 5, max = 50, message = "must have between 5 and 50 characters")
    @Email(message="invalid")
    private String email;
    @Column(length = 15)
    @Size(min = 5, max = 15, message = "must have between 5 and 15 characters")
    private String dni;
    @Column(nullable = false,length = 100)
    @NotNull
    @Size(min = 2, max = 100, message = "must have between 2 and 100 characters")
    private String firstName;
    @Column(nullable = false,length = 100)
    @NotNull
    @Size(min = 2, max = 100, message = "must have between 2 and 100 characters")
    private String lastName;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false, length = 20)
    private UserSexEnum sex;
    @NotNull
    @Column(columnDefinition = "DATE")
    @Past(message = "The date must be prior to the current date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Column(length = 500)
    private URL photoUrl;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date registration_date;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false, length = 15)
    private UserRoleEnum role;
    @Column(length = 150)
    @Size(max = 150, message = "must have max 150 characters")
    private String professionalDegree;
    @Column(length = 1000)
    @Size(max = 1000, message = "must have max 1000 characters")
    private String introductionText;
    @Column(nullable = false, columnDefinition = "TINYINT")
    @NotNull
    private Boolean locked;
    @Column(nullable = false, columnDefinition = "TINYINT")
    @NotNull
    private Boolean disabled;
    @Column(nullable = false, columnDefinition = "TINYINT")
    @NotNull
    private Boolean expired;
    @Column(nullable = false,length = 100)
    @NotNull
    private String password;

    @OneToMany(mappedBy = "users")
    private List<Comment> comments;

    @OneToMany(mappedBy = "users")
    private List<UserNote> userNotes;

    @OneToMany(mappedBy = "user")
    private List<UserContentCompleted> userContentCompleted;
}
