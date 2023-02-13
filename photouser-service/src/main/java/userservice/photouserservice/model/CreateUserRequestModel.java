package userservice.photouserservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
    @NotNull(message = "fistname should not be null")
    @Size(min = 2,message = "fistname must  min 2 characters")
    private String firstName;

    @NotNull(message = "lastname should not be null")
    @Size(min = 2,message = "lastname must  min 2 characters")
    private String lastName;

    @NotNull(message = "password should not be null")
    @Size(min = 8, max = 16, message = "password  must  8 to 16 characters")
    private String password;

    @NotNull(message = "email should not be null")
    @Email
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
