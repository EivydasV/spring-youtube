package com.project.youtube.channel;

import com.project.youtube.channel.dto.body.CreateChannelDTO;
import com.project.youtube.common.exception.ApiException;
import com.project.youtube.common.exception.BadRequestException;
import com.project.youtube.common.exception.UniqueConstrainsException;
import com.project.youtube.user.User;
import com.project.youtube.user.UserServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChannelService implements ChannelServiceInterface {

    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserServiceInterface userService;

    @Override
    public Page<Channel> findAll(Pageable pageable) {
        return channelRepository.findAll(pageable);
    }

    @Override
    public Channel saveChannel(CreateChannelDTO channel) {
        Channel channelEntity = modelMapper.map(channel, Channel.class);
        User user = userService.findById(channel.getUser()).orElseThrow();
        if (user.getChannel() != null) {
            throw new UniqueConstrainsException("User already has channel");
        }

        channelEntity.setUser(user);

        return channelRepository.save(channelEntity);
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
