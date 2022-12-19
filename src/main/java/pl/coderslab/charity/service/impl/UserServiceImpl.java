package pl.coderslab.charity.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(2);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(List.of(userRole)));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User registerUser(RegisterDto dto) {
        User user = dto.map(roleRepository.findByName("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User saveAdmin(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
//        Role userRole = roleRepository.findByName("ROLE_USER");
//        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole,adminRole)));
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }
}
