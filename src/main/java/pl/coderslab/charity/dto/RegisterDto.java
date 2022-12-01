package pl.coderslab.charity.dto;

import lombok.Data;
import pl.coderslab.charity.model.User;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class RegisterDto {
    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String password;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String confirmPassword;

    public User map(){
        if(!this.password.equals(this.confirmPassword)) {
            return null;
        }
        User users = new User();
        users.setEmail(this.email);
        users.setPassword(this.password);
        return users;
    }


}
