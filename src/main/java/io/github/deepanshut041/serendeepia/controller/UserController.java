package io.github.deepanshut041.serendeepia.controller;

import io.github.deepanshut041.serendeepia.domains.User;
import io.github.deepanshut041.serendeepia.service.UserService;
import io.github.deepanshut041.serendeepia.util.CurrentUser;
import io.github.deepanshut041.serendeepia.util.UserPrincipal;
import io.github.deepanshut041.serendeepia.util.exception.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Api(value = "User Route")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "Get your profile", authorizations = { @Authorization("Bearer")})
    public ResponseEntity<User> getCurrentUser() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findById(userPrincipal.getId());
        return ResponseEntity.ok(user);
    }

    @GetMapping({"", "/"})
    @ApiOperation(value = "Get your profile", authorizations = { @Authorization("Bearer")})
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
