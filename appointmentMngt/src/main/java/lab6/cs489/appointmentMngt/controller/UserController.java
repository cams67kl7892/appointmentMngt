package lab6.cs489.appointmentMngt.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lab6.cs489.appointmentMngt.dto.UserDto;
import lab6.cs489.appointmentMngt.model.User;
import lab6.cs489.appointmentMngt.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Users", description = "APIs for managing Users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public UserDto getCurrentUser() {
       return userService.getCurrentUser();
    }
}
