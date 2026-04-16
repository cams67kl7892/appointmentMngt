package lab6.cs489.appointmentMngt.service;

import lab6.cs489.appointmentMngt.dto.UserDto;

public interface UserService {

    public UserDto findByUserName(String userName);
}
