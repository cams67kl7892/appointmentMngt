package lab6.cs489.appointmentMngt.dto;

import lab6.cs489.appointmentMngt.model.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class AdapterDto {

    public static PatientDto convertToDto(Patient patient) {

        PatientDto dto = new PatientDto();

        dto.setLastName(patient.getLastName());
        dto.setPhoneNumber(patient.getPhoneNumber());
        dto.setEmail(patient.getEmail());

        if (patient.getAddress() != null) {
            AddressDto addressDto = new AddressDto();
            addressDto.setLocation(patient.getAddress().getLocation());
            dto.setAddress(addressDto);
        }

        if (patient.getAppointmentList() != null) {
            List<AppointmentDto> appointmentDtos = patient.getAppointmentList()
                    .stream()
                    .map(app -> {
                        AppointmentDto adto = new AppointmentDto();
                        adto.setAppointmentDate(app.getAppointmentDate());
                        adto.setAppointmentTime(app.getAppointmentTime());
                        return adto;
                    })
                    .collect(Collectors.toList());

            dto.setAppointmentList(appointmentDtos);
        }

        return dto;
    }
}
