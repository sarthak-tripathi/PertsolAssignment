package com.commentprojectexample.pertsolproject.repository;

import com.commentprojectexample.pertsolproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
//This interface extends JpaRepository to interact with the database using Spring Data JPA.
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBy(String by);
    List<Comment> findByDateofcomment(LocalDateTime dateofcomment);
}