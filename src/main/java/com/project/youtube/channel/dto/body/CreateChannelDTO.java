package com.project.youtube.channel.dto.body;

import com.project.youtube.user.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class CreateChannelDTO {

    @Size(max = 100, message = "{validation.name.size.too_long}")
    @NotBlank
    private String name;

    @NotNull
    private UUID user;
}
