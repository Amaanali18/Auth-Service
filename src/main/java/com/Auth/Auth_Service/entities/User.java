package com.Auth.Auth_Service.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private boolean enable = true;
    private Instant createdAt=Instant.now();
    private Instant updatedAt=Instant.now();

    @Enumerated(EnumType.STRING)
    private Provider provider = Provider.LOCAL;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        Instant now=Instant.now();
        if(createdAt==null) createdAt = now;
        updatedAt = now;
    }
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
    protected void onDelete() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }
}
