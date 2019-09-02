package io.github.deepanshut041.serendeepia.service;

import io.github.deepanshut041.serendeepia.domains.Role;
import io.github.deepanshut041.serendeepia.domains.User;
import io.github.deepanshut041.serendeepia.dto.RegisterDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    UserDetails loadUserById(Long id);

    Optional<User> findById(long id);

    boolean existsByEmail(String email);

    void save(RegisterDto registerDto, List<Role> roles);
}
