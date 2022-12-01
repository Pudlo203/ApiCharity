package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

    @GetMapping(value = "/register")
    public String formRegister(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "/register";
    }
    @PostMapping(value = "/register")
    public String formRegisterSubmit(@Valid @ModelAttribute("registerDto") RegisterDto registerDto, BindingResult result){
        User user = null;
        if (!result.hasErrors()) {
            user = userService.registerUser(registerDto);
            if (user != null) {
                return "redirect:/login";
            }
        }
        return "/register";
    }
}
