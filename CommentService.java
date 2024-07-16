package com.commentprojectexample.pertsolproject.service;

import com.commentprojectexample.pertsolproject.model.Comment;
import com.commentprojectexample.pertsolproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getCommentsByUsername(String username) {
        return commentRepository.findByBy(username);
    }

    public List<Comment> getCommentsByDate(LocalDateTime date) {
        return commentRepository.findByDateofcomment(date);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + id));

        comment.setBy(commentDetails.getBy());
        comment.setText(commentDetails.getText());
        comment.setDateofcomment(commentDetails.getDateofcomment());

        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + id));

        commentRepository.delete(comment);
    }
}