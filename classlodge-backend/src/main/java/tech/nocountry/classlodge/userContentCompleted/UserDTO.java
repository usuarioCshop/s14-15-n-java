package tech.nocountry.classlodge.userContentCompleted;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class UserDTO {
    private String email;
    private String contentId;
    private Date dateMarkedAsCompleted;
}