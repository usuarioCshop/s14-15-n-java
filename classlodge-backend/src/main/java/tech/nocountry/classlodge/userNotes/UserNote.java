package tech.nocountry.classlodge.userNotes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id; // PK de la tabla UserNotes

    private Integer contentId; //FK del contenido del curso
    private String email; // FK del usuario

    @Column(nullable = false, length = 500)
    @Size(max = 500)
    private String details;
    @Column(nullable = false, length = 1000)
    @NotNull
    @Size(min = 2, max = 1000)
    private String noteContent;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTaken;
}
