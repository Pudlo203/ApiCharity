package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findByEmail(String email);
    User registerUser(RegisterDto dto);

    User saveAdmin(User user);
    void delete(Long id);
    void update(User user);
    Optional<User> get(Long id);
}
