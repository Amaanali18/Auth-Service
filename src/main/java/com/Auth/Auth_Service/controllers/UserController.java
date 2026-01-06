package com.Auth.Auth_Service.controllers;

import com.Auth.Auth_Service.dtos.UserDTO;
import com.Auth.Auth_Service.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }
    @GetMapping
    public ResponseEntity<Iterable<UserDTO>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
    @GetMapping("/email/{email_id}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable("email_id") String emailId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(emailId));
    }
    @DeleteMapping("/{user_id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("user_id") String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getUserByEmail(userId));
    }
    @PutMapping("/{user_id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("user_id") String userId, @RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO,userId);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(userId));
    }
}
