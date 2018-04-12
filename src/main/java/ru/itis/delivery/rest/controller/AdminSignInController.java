package ru.itis.delivery.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.delivery.model.User;
import ru.itis.delivery.service.UserService;
import ru.itis.delivery.rest.dto.UserDto;

import javax.validation.Valid;

@Controller("/signin")
public class AdminSignInController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @ModelAttribute("admin")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        LOGGER.debug("Rendering registration page.");
        return "signin";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
                                      BindingResult result) {

        User user = userService.findByEmail(userDto.getEmail());
        if (user != null) {
            result.rejectValue("email", null, "Уже существует аккаунт с таким email-ом");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
