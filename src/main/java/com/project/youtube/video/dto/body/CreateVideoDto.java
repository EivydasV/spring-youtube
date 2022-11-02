package com.project.youtube.video.dto.body;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class CreateVideoDto {
    @NotBlank
    @Size(max = 100, message = "{validation.name.size.too_long}")
    private String title;

    @NotBlank
    @Size(max = 10000, message = "{validation.name.size.too_long}")
    private String description;

    @NotBlank
    @Size(max = 500, message = "{validation.name.size.too_long}")
    private String url;

    @NotNull
    @Positive
    private int duration;

    @NotNull
    private UUID channelId;

}
