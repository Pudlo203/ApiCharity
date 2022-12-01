package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findByEmail(String email);
    User registerUser(RegisterDto dto);
}
