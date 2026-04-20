package lab6.cs489.appointmentMngt.service.impl;

import lab6.cs489.appointmentMngt.dto.UserDto;
import lab6.cs489.appointmentMngt.repository.UserRepository;
import lab6.cs489.appointmentMngt.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
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
}
