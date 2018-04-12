package ru.itis.delivery.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itis.delivery.model.User;
import ru.itis.delivery.service.UserService;
import ru.itis.delivery.rest.dto.UserDto;

import javax.validation.Valid;

@Controller("/admin")
public class AdminLogInController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDto userLoginDto() {
        return new UserDto();
    }

    @ModelAttribute("user")
    public User login(@Valid UserDto userDto, BindingResult result) {

        User user = userService.findByEmail(userDto.getEmail());
        if (user != null) {
            return user;
        }

        if (result.hasErrors()) {
            return null;
        }
        return null;
    }
}
