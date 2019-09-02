package io.github.deepanshut041.serendeepia.service;

import io.github.deepanshut041.serendeepia.domains.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    UserDetails loadUserById(Long id);

    Optional<User> findById(long id);

    boolean existsByEmail(String email);

    User save(User user);
}
