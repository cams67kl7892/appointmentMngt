package lab6.cs489.appointmentMngt.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lab6.cs489.appointmentMngt.model.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DentistDto {
    private Long dentistId;
    private String  firstName;
    private String lastName;
    private String phoneNumber;
}
