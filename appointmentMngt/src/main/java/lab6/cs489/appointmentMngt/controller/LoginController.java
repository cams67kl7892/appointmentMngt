package lab6.cs489.appointmentMngt.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lab6.cs489.appointmentMngt.dto.UserResponseDto;
import lab6.cs489.appointmentMngt.service.impl.UserServiceImpl;
import lab6.cs489.appointmentMngt.utils.JwtUtils;
import lab6.cs489.appointmentMngt.vo.AuthRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
@Tag(name = "Authentication", description = "APIs for managing authentication")
public class LoginController {

    private AuthenticationManager authenticationManager;
    private UserServiceImpl userService;
    private PasswordEncoder passwordEncoder;
    private JwtUtils jwtUtil;

    public LoginController(AuthenticationManager authenticationManager, UserServiceImpl userService, PasswordEncoder passwordEncoder, JwtUtils jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signIn")
    public UserResponseDto authenticateUser(@RequestBody AuthRequest user) {

        Authentication authentication = authenticationManager.authenticate(
                new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
      //  log.info("Authenticating user: {}", userDetails.getUsername());
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserName(userDetails.getUsername());
        userResponseDto.setToken(jwtUtil.generateToken(userDetails.getUsername()));

        return userResponseDto;
    }
}