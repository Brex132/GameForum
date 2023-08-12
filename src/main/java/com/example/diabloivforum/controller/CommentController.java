package com.example.diabloivforum.controller;

import com.example.diabloivforum.model.Comment;
import com.example.diabloivforum.model.Problem;
import com.example.diabloivforum.repository.CommentRepository;
import com.example.diabloivforum.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {
    private final CommentRepository commentRepository;
    private final ProblemRepository problemRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository, ProblemRepository problemRepository) {
        this.commentRepository = commentRepository;
        this.problemRepository = problemRepository;
    }

    @GetMapping("/")
    public String getComments(Model model) {
        List<Comment> comments = commentRepository.findAll();
        List<Problem> problems = problemRepository.findAll();

        model.addAttribute("comments", comments);
        model.addAttribute("posts", problems);
        return "index";
    }

    @PostMapping("/comments")
    public String saveComment(@RequestParam("postId") Long postId,
                              @RequestParam("commentText") String commentText) {
        Problem problem = problemRepository
                .findById(postId)
                .orElseThrow(() -> new RuntimeException("No post with id: " + postId));

        Comment comment = new Comment();
        comment.setProblem(problem);
        comment.setText(commentText);

        commentRepository.save(comment);

        return "redirect:/problems?id=" + postId;
    }
}

