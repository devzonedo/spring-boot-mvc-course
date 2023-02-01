package com.devz.app.ws.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailRequestModel {
    @NotNull(message="firstName can not be empty")
    @Size(min = 2, message = "first name too short")
    private String firstName;
    @NotNull (message="lastName can not be empty")
    private String lastName;

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
}
