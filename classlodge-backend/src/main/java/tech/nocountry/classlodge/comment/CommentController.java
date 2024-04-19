package tech.nocountry.classlodge.comment;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("api/v1/comment")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /*public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }
     */
    //Crear una DTO PARA ESTE END POINT
    @PostMapping(path = "/post{courseId}")
    @Operation(summary = "This endpoint create a new comment.", tags = {"Comentario"} )
    public ResponseEntity<Object> createComment(@RequestBody @Valid Comment comment,
                                                @RequestParam("courseId") Integer courseId){
        if (isNull(courseId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Comment createdComment = commentService.createComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @GetMapping(path="/{id}")
    @Operation(summary = "This endpoint retrieve a comment by its id.", tags = {"Comentario"} )
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Integer id){
        Optional<Comment> optionalComment = commentService.getCommentById(id);
        return optionalComment.map(comment -> ResponseEntity.ok().body(comment))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/course/{courseId}")
    @Operation(summary = "This endpoint retrieve all the comments in a course by course id.", tags = {"Comentario"} )
    public ResponseEntity<List<Comment>> getAllCommentByCourseId(@PathVariable Integer courseId){
        List<Comment> comments = commentService.getAllCommentsByCourseId(courseId);
        if(comments.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(comments);
    }

    @PutMapping("/{id}")
    @Operation(summary = "This endpoint update a comment by its id.", tags = {"Comentario"} )
    public ResponseEntity<Comment> updatedComment(@PathVariable Integer id, @Valid @RequestBody Comment updatedComment){
        Comment existingComment = commentService.updateComment(id, updatedComment);
        if(existingComment != null){
            return ResponseEntity.ok().body(existingComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "This endpoint delete a comment by its id.", tags = {"Comentario"} )
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
