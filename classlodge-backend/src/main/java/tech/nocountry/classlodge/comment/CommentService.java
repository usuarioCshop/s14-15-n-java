package tech.nocountry.classlodge.comment;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    Optional<Comment> getCommentById(Integer id);
    List<Comment> getAllCommentsByCourseId(Integer courseId);
     Comment updateComment(Integer id, Comment updatedComment);
    void deleteComment(Integer id);
}
