package com.Auth.Auth_Service.services;

import com.Auth.Auth_Service.dtos.UserDTO;
import com.Auth.Auth_Service.entities.Provider;
import com.Auth.Auth_Service.entities.User;
import com.Auth.Auth_Service.exceptions.ResourceNotFound;
import com.Auth.Auth_Service.helpers.userHelper;
import com.Auth.Auth_Service.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        if(userDTO.getEmail()==null || userDTO.getEmail().isEmpty()){
            throw new IllegalArgumentException("Email is required");
        }
        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }
        User user = modelMapper.map(userDTO, User.class);
        user.setProvider(userDTO.getProvider()!=null?userDTO.getProvider(): Provider.LOCAL);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFound("User not found"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String user_id) {
        UUID userId = userHelper.parseUUID(user_id);
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (userDTO.getUsername() != null) existingUser.setUsername(userDTO.getUsername());
        if (userDTO.getPassword() != null) existingUser.setPassword(userDTO.getPassword());
        User savedUser = userRepository.save(existingUser);
        return modelMapper.map(savedUser, UserDTO.class);
    }
    @Override
    public void deleteUser(String user_id) {
        UUID userId = userHelper.parseUUID(user_id);
        userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found cannot delete"));
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO getUserById(String user_id) {
        UUID userId = userHelper.parseUUID(user_id);
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found with id"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    @Transactional
    public Iterable<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user,UserDTO.class))
                .toList();
    }

}
