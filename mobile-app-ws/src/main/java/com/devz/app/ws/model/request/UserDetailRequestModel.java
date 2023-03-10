package com.devz.app.ws.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequestModel {
    @NotNull (message="firstName can not be empty")
    @Size(min = 2, message = "first name too short")
    private String firstName;
    @NotNull (message="lastName can not be empty")
    private String lastName;
    @NotNull (message="email can not be empty")
    @Email
    private String email;
    @NotNull
    @Size(min = 8,max = 16,message = "invalid password constraint")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
