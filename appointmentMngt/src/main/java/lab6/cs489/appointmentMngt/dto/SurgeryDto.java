package lab6.cs489.appointmentMngt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SurgeryDto {
    private Long surgeryId;
    private String name;
    private String phoneNumber;
    private AddressDto address;
}
