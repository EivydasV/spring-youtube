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
        return channelRepository.save(channel);
    }

    @Override
    public Optional<Channel> findById(UUID id) {
        return channelRepository.findById(id);
    }

    @Override
    public Optional<Channel> findByName(String name) {
        return channelRepository.findByName(name);
    }
}
