package com.finan_control.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(@NotBlank @Email String email,
                            @NotBlank String password,
                            @NotBlank String name) {
}
