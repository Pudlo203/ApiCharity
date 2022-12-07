package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final HttpSession session;

    @GetMapping("/login")
    public String loginPageForm(Model model, User user) {
        model.addAttribute("user", user);
        return "login";
    }
    @PostMapping(value = "/logout")
    public String logout() {


        return "redirect:/";
    }


    @GetMapping(value = "/register")
    public String formRegister(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "/register";
    }
    @PostMapping(value = "/register")
    public String formRegisterSubmit(@Valid @ModelAttribute("registerDto") RegisterDto registerDto, BindingResult result){
        User user = null;
//        if (user.getEmail() != null && userService.findByEmail(user.getEmail()).isPresent()) {
//            result.addError(new FieldError("user", "email", "Istnieje użytkownik o wskazanym adresie"));
//        }
//        if (registerDto.getConfirmPassword() != null && user.getPassword() != null && !registerDto.getConfirmPassword().equals(user.getPassword())) {
//            result.addError(new FieldError("user", "password", "Wprowadzono różne hasła"));
//        }
        if (!result.hasErrors()) {
            user = userService.registerUser(registerDto);
            if (user != null) {
                return "redirect:/login";
            }
        }
        return "/register";
    }
}
