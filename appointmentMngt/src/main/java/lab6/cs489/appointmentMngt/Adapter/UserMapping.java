package lab6.cs489.appointmentMngt.Adapter;

import lab6.cs489.appointmentMngt.dto.RoleDto;
import lab6.cs489.appointmentMngt.dto.UserDto;
import lab6.cs489.appointmentMngt.dto.UserResponseDto;
import lab6.cs489.appointmentMngt.model.Role;
import lab6.cs489.appointmentMngt.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserMapping {

    public static UserDto toDto(User user) {
        if(user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setRoleList(Optional.ofNullable(user.getRoleList())
                .orElse(Collections.emptySet())
                .stream()
                .map(RoleMapping::toDto)
                .collect(Collectors.toSet())
        );
        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        if(userDto == null) {
            return null;
        }

        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRoleList(userDto.getRoleList()
                .stream()
                .map(RoleMapping::toEntity)
                .collect(Collectors.toSet())
        );
        return user;
    }

//    public static UserResponseDto toDto(User user) {
//        UserResponseDto userResponseDto = new UserResponseDto();
//        userResponseDto.setUserName(user.getUserName());
//       // use
//
//        return userResponseDto;
//    }
}
