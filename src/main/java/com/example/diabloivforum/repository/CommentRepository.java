package com.example.diabloivforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.diabloivforum.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {


}
