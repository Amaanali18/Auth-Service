package com.Auth.Auth_Service.services;

import com.Auth.Auth_Service.dtos.UserDTO;
import com.Auth.Auth_Service.entities.User;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserByEmail(String email);
    UserDTO updateUser(UserDTO userDTO,String user_id);
    void deleteUser(String user_id);
    UserDTO getUserById(String user_id);
    Iterable<UserDTO> getAllUsers();
}
