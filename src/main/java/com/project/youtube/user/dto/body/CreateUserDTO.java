package com.project.youtube.user.dto.body;

import com.project.youtube.user.User;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CreateUserDTO {
        @NotBlank
        @Size(max = 50, message = "{validation.name.size.too_long}")
        private String name;

        @NotBlank
        @Email
        private String email;

        @NotBlank
        @Size(min = 8, max = 200)
        private String password;

        @NotNull
        @Positive
        private int age;
}
