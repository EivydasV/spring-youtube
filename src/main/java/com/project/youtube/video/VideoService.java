package com.project.youtube.video;

import com.project.youtube.channel.ChannelService;
import com.project.youtube.video.dto.body.CreateVideoDto;
import org.modelmapper.ModelMapper;
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

    @Autowired
    ChannelService channelService;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Page<Video> findAll(Pageable pageable) {
        return videoRepository.findAll(pageable);
    }

    @Override
    public Video saveVideo(CreateVideoDto video) {
        Video videoEntity = modelMapper.map(video, Video.class);

        channelService.findById(video.getChannelId()).ifPresentOrElse(
                videoEntity::setChannel,
                () -> {
                    throw new RuntimeException("Channel not found");
                }
        );
        return videoRepository.save(videoEntity);
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
