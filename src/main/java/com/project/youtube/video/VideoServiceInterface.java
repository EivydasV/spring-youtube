package com.project.youtube.video;

import com.project.youtube.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface VideoServiceInterface {
    Page<Video> findAll(Pageable pageable);
    Video saveVideo(Video video);
    Video updateVideo(UUID id);
    void deleteVideo(UUID id);
    Optional<Video> findById(UUID id);
    Optional<Video> findBySlug(String slug);
}

