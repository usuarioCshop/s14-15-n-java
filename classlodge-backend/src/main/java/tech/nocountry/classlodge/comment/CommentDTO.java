import tech.nocountry.classlodge.comment.CommentTypeOfCommentEnum;
import lombok.Data;

@Data
public class CommentDTO {
    private Integer courseId;
    private String userId;
    private CommentTypeOfCommentEnum commentType;
    private String comment;
    private Integer ratingAwarded;
}
