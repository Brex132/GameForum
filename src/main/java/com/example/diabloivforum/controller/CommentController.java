package com.example.diabloivforum.controller;

import com.example.diabloivforum.model.Comment;
import com.example.diabloivforum.repository.CommentRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class CommentController {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @GetMapping("/")
    public String getComments(Model model){
        List<Comment> comments = commentRepository.findAll();
        //need fix
        comments.sort(Comparator.comparing(Comment::getText).reversed());
        model.addAttribute("comments", comments);
        return "index";
    }
    @PostMapping("/")
    public String saveComment(@RequestParam("commentText") String commentText){
        Comment comment = new Comment();
        comment.setText(commentText);
        commentRepository.save(comment);
        return "redirect:/";
    }
}
