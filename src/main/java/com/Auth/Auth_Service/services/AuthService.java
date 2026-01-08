package com.Auth.Auth_Service.services;

import com.Auth.Auth_Service.dtos.UserDTO;

public interface AuthService {
    UserDTO registerUser(UserDTO userDTO);
}
