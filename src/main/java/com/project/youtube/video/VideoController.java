package com.project.youtube.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

    @Autowired
    VideoServiceInterface videoService;

    @PostMapping
    Video createVideo(@Valid @RequestBody Video video){
        return videoService.saveVideo(video);
    }

    @GetMapping
    Page<Video> getVideos(Pageable pageable){
        return videoService.findAll(pageable);
    }

    @GetMapping("findById/{id}")
    Video getVideoById(@PathVariable("id") UUID id){
        return videoService.findById(id).orElseThrow();
    }

    @GetMapping("findBySlug/{slug}")
    Video getVideoByTitle(@PathVariable("slug") String slug){
        return videoService.findBySlug(slug).orElseThrow();
    }

    @DeleteMapping("deleteById/{id}")
    void deleteVideoById(@PathVariable("id") UUID id){
        videoService.deleteVideo(id);
    }
}
