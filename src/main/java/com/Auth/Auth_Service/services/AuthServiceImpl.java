package com.Auth.Auth_Service.services;

import com.Auth.Auth_Service.dtos.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
}
