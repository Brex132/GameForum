package com.example.diabloivforum.repository;

import com.example.diabloivforum.model.Comment;
import com.example.diabloivforum.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByProblem(Problem problem);
}
