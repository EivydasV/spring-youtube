package com.project.youtube.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService implements CommentServiceInterface {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Page<Comment> findCommentsByVideoId(UUID videoId, Pageable pageable) {

        return null;
    }

    @Override
    public Optional<Comment> findCommentById(UUID id) {
        return commentRepository.findById(id);
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
