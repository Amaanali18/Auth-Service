package com.Auth.Auth_Service.services;

import com.Auth.Auth_Service.dtos.UserDTO;
import com.Auth.Auth_Service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String user_id) {
        return null;
    }

    @Override
    public void deleteUser(String user_id) {

    }

    @Override
    public UserDTO getUserById(String user_id) {
        return null;
    }

    @Override
    public Iterable<UserDTO> getAllUsers() {
        return null;
    }
}
