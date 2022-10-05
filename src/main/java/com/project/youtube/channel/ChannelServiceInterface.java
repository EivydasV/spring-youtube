package com.project.youtube.channel;

import com.project.youtube.video.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ChannelServiceInterface {
    Page<Channel> findAll(Pageable pageable);
    Channel saveVideo(Channel channel);
    Optional<Channel> findById(UUID id);
    Optional<Channel> findByName(String name);
    Optional<Channel> findByCreatedBy(UUID id);
}
