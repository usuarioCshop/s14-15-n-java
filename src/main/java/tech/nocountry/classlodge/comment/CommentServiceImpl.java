package tech.nocountry.classlodge.comment;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @Override
    //Crear un comentario
    public Comment createComment(@Valid Comment comment){
        try {
            return commentRepository.save(comment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create comment: " + e.getMessage(), e);
        }
    }

    //Recuperar un comentario por su ID
    public Optional<Comment> getCommentById(Integer id){
        try {
            return commentRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve comment: " + e.getMessage(), e);
        }
    }

    public List<Comment> getAllCommentsByCourseId(Integer courseId) {
        try {
            List<Comment> comments = commentRepository.findAllCommentsByCourseId(courseId);
            if (comments.isEmpty()) {
                throw new NoSuchElementException("No comments found for course with id: " + courseId);
            }
            return comments;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve comments: " + e.getMessage(), e);
        }
    }

    // Actualizar un comentario por su id
    public Comment updateComment(Integer id, @Valid Comment updatedComment) {
        try {
            Optional<Comment> optionalComment = commentRepository.findById(id);
            if (optionalComment.isPresent()) {
                Comment existingComment = optionalComment.get();
                existingComment.setComment(updatedComment.getComment());
                existingComment.setRatingAwarded(updatedComment.getRatingAwarded());
                existingComment.setPostDate(new Date());
                return commentRepository.save(existingComment);
            } else {
                throw new NoSuchElementException("Comment not found with id: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update comment: " + e.getMessage(), e);
        }
    }

    //Eliminar un comentario por su ID
    public void deleteComment(Integer id){
        try {
            commentRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete comment: " + e.getMessage(), e);
        }
    }
}
