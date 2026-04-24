package lab6.cs489.appointmentMngt.Adapter;

import lab6.cs489.appointmentMngt.dto.RoleDto;
import lab6.cs489.appointmentMngt.model.Role;

import java.util.stream.Collectors;

public class RoleMapping {

    public static RoleDto toDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName(role.getRoleName());

        return roleDto;
    }

    public static Role toEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setRoleName(roleDto.getRoleName());

        return role;
    }
}
