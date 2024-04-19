package tech.nocountry.classlodge.userContentCompleted;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserContentCompletedId implements Serializable {
    @Column(name = "content_id")
    private Integer contentId;

    @Column(length = 50)
    private String email;
}
