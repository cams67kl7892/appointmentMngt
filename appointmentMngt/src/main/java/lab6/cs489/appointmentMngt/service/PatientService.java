package lab6.cs489.appointmentMngt.service;


import lab6.cs489.appointmentMngt.dto.AddressDto;
import lab6.cs489.appointmentMngt.dto.AppointmentDto;
import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.exceptions.ResourceNotFoundException;
import lab6.cs489.appointmentMngt.model.Address;
import lab6.cs489.appointmentMngt.model.Patient;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private PatientRepository patientRepository;


    public PatientDto getPatientById(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        return convertToDto(patient);
    }


    public List<PatientDto> searchPatients(String searchString) {

        List<Patient> patients = patientRepository.searchPatients(searchString);

        return patients.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PatientDto convertToDto(Patient patient) {

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
