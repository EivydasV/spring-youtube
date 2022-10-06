package com.project.youtube.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentService implements CommentServiceInterface {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Page<Comment> findCommentsByVideoId(UUID videoId, Pageable pageable) {
        return null;
    }
}
