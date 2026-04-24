package lab6.cs489.appointmentMngt.service;

import lab6.cs489.appointmentMngt.dto.UserDto;
import lab6.cs489.appointmentMngt.model.User;

public interface UserService {

    public UserDto findByUserName(String userName);

    public UserDto getCurrentUser();
}
