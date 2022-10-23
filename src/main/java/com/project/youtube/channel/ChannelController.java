package com.project.youtube.channel;


import com.project.youtube.channel.dto.body.CreateChannelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/channels")
public class ChannelController {

    @Autowired
    ChannelServiceInterface channelService;

    @PostMapping
    Channel createChannel(@Valid @RequestBody CreateChannelDTO channel){
        return channelService.saveChannel(channel);
    }

    @GetMapping("/findById/{id}")
    Channel findById(@PathVariable UUID id){
        return channelService.findById(id).orElseThrow();
    }

    @GetMapping("/findByName/{name}")
    Channel findByName(@PathVariable String name){
        return channelService.findByName(name).orElseThrow();
    }
}
