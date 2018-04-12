package ru.itis.delivery.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.delivery.model.User;
import ru.itis.delivery.rest.URLs;
import ru.itis.delivery.service.UserService;
import ru.itis.delivery.rest.dto.UserDto;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = URLs.URL_LOGIN) // /login
public class UserLogInController {
    private static final Logger log = LoggerFactory.getLogger(UserLogInController.class);
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDto userLoginDto() {
        return new UserDto();
    }

    @ModelAttribute("user")
    public User login(@Valid UserDto userDto, BindingResult result) {

        if (userService.isDisabled()) {
            response.setStatus(HttpServletResponse.SC_OK);
            return null;
        }

        String login = userAuth.getLogin();
        String password = userAuth.getPassword();

        if (login == null || login.isEmpty()
                || password == null || password.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
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
