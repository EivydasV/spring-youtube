package com.project.youtube.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ChannelService implements ChannelServiceInterface {

    @Autowired
    ChannelRepository channelRepository;

    @Override
    public Page<Channel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Channel saveVideo(Channel channel) {
        return null;
    }

    @Override
    public Optional<Channel> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Channel> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Channel> findByCreatedBy(UUID id) {
        return Optional.empty();
    }
}
