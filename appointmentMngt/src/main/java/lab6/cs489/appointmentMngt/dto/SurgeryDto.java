package lab6.cs489.appointmentMngt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SurgeryDto {
    private String name;
    private String phoneNumber;
    private AddressDto address;
    List<AppointmentDto> appointmentList;
}
