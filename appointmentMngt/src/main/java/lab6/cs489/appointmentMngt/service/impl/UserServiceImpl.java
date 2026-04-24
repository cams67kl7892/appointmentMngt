package lab6.cs489.appointmentMngt.service.impl;

import lab6.cs489.appointmentMngt.Adapter.UserMapping;
import lab6.cs489.appointmentMngt.dto.UserDto;
import lab6.cs489.appointmentMngt.model.Role;
import lab6.cs489.appointmentMngt.model.User;
import lab6.cs489.appointmentMngt.repository.UserRepository;
import lab6.cs489.appointmentMngt.service.UserService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@ToString
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDto findByUserName(String userName) {
        return modelMapper.map(userRepository.findByUserName(userName), UserDto.class);
    }

    public UserDto getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUserName(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapping.toDto(user);
    }
}
