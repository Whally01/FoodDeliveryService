package ru.itis.delivery.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.itis.delivery.model.User;
import ru.itis.delivery.rest.dto.UserDto;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);

    User save(UserDto registration);
}
