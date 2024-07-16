package com.commentprojectexample.pertsolproject.controller;

import com.commentprojectexample.pertsolproject.model.Comment;
import com.commentprojectexample.pertsolproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v2/comments")
public class controller {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/search")
    public List<Comment> searchComments(@RequestParam(required = false) String username, @RequestParam(required = false) String date) {
        if (username != null) {
            return commentService.getCommentsByUsername(username);
        } else if (date != null) {
            return commentService.getCommentsByDate(LocalDateTime.parse(date));
        }
        return List.of();
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.updateComment(id, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
