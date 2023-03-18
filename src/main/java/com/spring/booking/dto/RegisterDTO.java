package com.spring.booking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegisterDTO {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @Email(message = "Email provided is not valid")
    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;

    public RegisterDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
