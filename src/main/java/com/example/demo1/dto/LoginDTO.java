package com.example.demo1.dto;

import io.micrometer.common.lang.NonNull;
import lombok.Data;

@Data
public class LoginDTO {
    @NonNull
    private String email;

    @NonNull
    private String passWord;
}