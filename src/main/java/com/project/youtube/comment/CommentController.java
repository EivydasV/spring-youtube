package com.project.youtube.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    CommentServiceInterface commentService;

    @PostMapping
    Comment createComment(@Valid @RequestBody Comment comment){
        return commentService.saveComment(comment);
    }

    @GetMapping
    Page<Comment> getComments(Pageable pageable){
        return commentService.findAll(pageable);
    }

    @GetMapping("findById/{id}")
    Comment getCommentById(@PathVariable("id") UUID id){
        return commentService.findCommentById(id).orElseThrow();
    }

}
