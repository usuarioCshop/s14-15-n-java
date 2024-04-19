package tech.nocountry.classlodge.userContentCompleted;

import java.util.Date;

public record UserContentCompletedUpdateDTO(Date dateMarkedAsCompleted) {
    public Date getDateMarkedAsCompleted() {
        return dateMarkedAsCompleted;
    }
}
