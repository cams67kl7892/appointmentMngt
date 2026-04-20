package lab6.cs489.appointmentMngt.controller;

import lab6.cs489.appointmentMngt.service.impl.UserServiceImpl;
import lab6.cs489.appointmentMngt.utils.JwtUtils;
import lab6.cs489.appointmentMngt.vo.AuthRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
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

    @PostMapping("/login")
    public String authenticateUser(@RequestBody AuthRequest user) {

        Authentication authentication = authenticationManager.authenticate(
                new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.info("Authenticating user: {}", userDetails.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername());
    }
}