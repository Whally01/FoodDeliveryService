package ru.itis.delivery.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.delivery.service.UserService;
import ru.itis.delivery.rest.dto.UserDto;

@RestController("/user")
public class UserSignInController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }

    /*@GetMapping
    public String showRegistrationForm(Model model) {
        LOGGER.debug("Rendering registration page.");
        return "registration";
    }*/

   /* @PostMapping
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
    }*/

}
