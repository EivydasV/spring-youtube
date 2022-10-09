package com.project.youtube.channel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/channels")
public class ChannelController {

    @Autowired
    ChannelServiceInterface channelService;

    @PostMapping
    Channel createChannel(@Valid @RequestBody Channel channel){
        return channelService.saveVideo(channel);
    }
}
