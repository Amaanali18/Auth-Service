package com.Auth.Auth_Service.dtos;
import com.Auth.Auth_Service.entities.Provider;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private UUID id;
    private String email;
    private String username;
    private String password;
    private Provider provider = Provider.LOCAL;
    private Set<RoleDTO> roles = new HashSet<>();
}
