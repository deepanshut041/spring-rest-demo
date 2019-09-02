package io.github.deepanshut041.serendeepia.controller;

import io.github.deepanshut041.serendeepia.domains.User;
import io.github.deepanshut041.serendeepia.service.UserService;
import io.github.deepanshut041.serendeepia.util.CurrentUser;
import io.github.deepanshut041.serendeepia.util.UserPrincipal;
import io.github.deepanshut041.serendeepia.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userService.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
