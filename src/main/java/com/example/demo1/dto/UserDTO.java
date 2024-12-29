package com.example.demo1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.AssertTrue;

@Data
public class UserDTO {
    private String userName; 

    @NotBlank(message = "First name is required")
    private String name; 

    @NotBlank(message = "Last name is required")
    private String lastName; 
    @Email(message = "Email should be valid")
    private String email;

    private String password;

    private String confirmPassword;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordValid() {
        return password != null && password.equals(confirmPassword);
    }
}
