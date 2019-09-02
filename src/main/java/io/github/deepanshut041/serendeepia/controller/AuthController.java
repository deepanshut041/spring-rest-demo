package io.github.deepanshut041.serendeepia.controller;

import io.github.deepanshut041.serendeepia.domains.User;
import io.github.deepanshut041.serendeepia.dto.ApiResponse;
import io.github.deepanshut041.serendeepia.dto.AuthResponse;
import io.github.deepanshut041.serendeepia.dto.LoginDto;
import io.github.deepanshut041.serendeepia.dto.RegisterDto;
import io.github.deepanshut041.serendeepia.service.RoleService;
import io.github.deepanshut041.serendeepia.service.UserService;
import io.github.deepanshut041.serendeepia.util.JwtTokenUtil;
import io.github.deepanshut041.serendeepia.util.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenUtil.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDto registerDto) {
        if(userService.existsByEmail(registerDto.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        // Creating user's account
        User user = new User();
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roleService.findByName("ROLE_USER"));

        userService.save(user);

        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully@"));
    }

}

