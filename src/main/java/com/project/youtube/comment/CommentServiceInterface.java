package com.project.youtube.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CommentServiceInterface {
    Page<Comment> findCommentsByVideoId(UUID videoId, Pageable pageable);
    Optional<Comment> findCommentById(UUID id);

    Page<Comment> findAll(Pageable pageable);

    Comment saveComment(Comment comment);
}
