package lab6.cs489.appointmentMngt.dto;

import lab6.cs489.appointmentMngt.model.Dentist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

}
