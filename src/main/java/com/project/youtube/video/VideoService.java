package com.project.youtube.video;

import com.project.youtube.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class VideoService implements VideoServiceInterface {

    @Autowired
    VideoRepository videoRepository;


    @Override
    public Page<Video> findAll(Pageable pageable) {
        return videoRepository.findAll(pageable);
    }

    @Override
    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video updateVideo(UUID id) {
        return null;
    }

    @Override
    public void deleteVideo(UUID id) {
        videoRepository.deleteById(id);
    }

    @Override
    public Optional<Video> findById(UUID id) {
        return videoRepository.findById(id);
    }

    @Override
    public Optional<Video> findBySlug(String title) {
        return videoRepository.findBySlug(title);
    }
}
