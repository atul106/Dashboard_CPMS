package com.dashboard.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {

    @NotBlank(message = "User name cannot be empty !!")
    @Size(min = 4,max = 50,message = "Username must be between 4-12 characters")

    private String username;

    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Invalid Password, Min 1 uppercase letter.\n" +
            "Min 1 lowercase letter.\n" +
            "Min 1 special character.\n" +
            "Min 1 number.\n" +
            "Min 8 characters")
    private String password;

    @AssertTrue
    private boolean agreed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Boolean getAgreed() {
        return agreed;
    }

    public void setAgreed(Boolean agreed) {
        this.agreed = agreed;
    }
}
