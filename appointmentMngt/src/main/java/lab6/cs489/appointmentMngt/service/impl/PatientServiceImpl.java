package lab6.cs489.appointmentMngt.service.impl;


import lab6.cs489.appointmentMngt.dto.AddressDto;
import lab6.cs489.appointmentMngt.dto.AppointmentDto;
import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.exceptions.ResourceNotFoundException;
import lab6.cs489.appointmentMngt.model.Address;
import lab6.cs489.appointmentMngt.model.Patient;
import lab6.cs489.appointmentMngt.repository.AddressRepository;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import lab6.cs489.appointmentMngt.service.PatientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;
  //  private final AddressRepository addressRepository;

    public List<PatientDto> getPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

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

    public PatientDto createPatient(PatientDto dto) {
        Patient patient = convertToEntity(dto);
        patientRepository.save(patient);
        return convertToDto(patient);
    }

    public String deletePatient(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Patient id must not be null");
        }
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found with id: " + id));

        patientRepository.delete(patient);
        return "Patient deleted successfully";
    }


    public PatientDto updatePatient(@PathVariable Long id, @RequestBody PatientDto dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found with id: " + id));
        patient.setPatientId(id);
        patient.setFistName(dto.getFistName());
        patient.setLastName(dto.getLastName());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setEmail(dto.getEmail());

        if (dto.getAddress() != null) {
            Address address = patient.getAddress();
            if (address == null) {
                address = new Address();
            }
            address.setLocation(dto.getAddress().getLocation());
            patient.setAddress(address);
        }
        Patient patientUpdated = patientRepository.save(patient);

        return convertToDto(patientUpdated);
    }

    public PatientDto convertToDto(Patient patient) {
        return modelMapper.map(patient, PatientDto.class);
    }

    public Patient convertToEntity(PatientDto patientDto) {
        return modelMapper.map(patientDto, Patient.class);
    }
}
