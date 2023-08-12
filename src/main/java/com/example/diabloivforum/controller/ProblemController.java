package com.example.diabloivforum.controller;

import com.example.diabloivforum.model.Comment;
import com.example.diabloivforum.model.Problem;
import com.example.diabloivforum.repository.CommentRepository;
import com.example.diabloivforum.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProblemController {
    private final ProblemRepository problemRepository;
    private final CommentRepository commentRepository;


    @Autowired
    public ProblemController(ProblemRepository problemRepository, CommentRepository commentRepository) {

        this.problemRepository = problemRepository;

        this.commentRepository = commentRepository;
    }

    @PostMapping(value = "/problems", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveProblem(String postTitle, String postContent) {
        Problem problem = new Problem();
        problem.setTitle(postTitle);
        problem.setDescription(postContent);
        problemRepository.save(problem);

        return "redirect:/";
    }


    @GetMapping("/problems")
    public String getAllProblems(@RequestParam long id, Model model) {
        Problem problem = problemRepository.findById(id).orElseThrow();
        List<Comment> allCommentsOfThePost = commentRepository.findAllByProblem(problem);

        model.addAttribute("post", problem);
        model.addAttribute("comments", allCommentsOfThePost);

        return "problem";
    }
}