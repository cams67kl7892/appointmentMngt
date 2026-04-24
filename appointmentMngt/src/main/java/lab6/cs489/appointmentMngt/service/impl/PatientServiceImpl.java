package lab6.cs489.appointmentMngt.service.impl;

import lab6.cs489.appointmentMngt.Adapter.PatientMapping;
import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.exceptions.ResourceNotFoundException;
import lab6.cs489.appointmentMngt.model.Address;
import lab6.cs489.appointmentMngt.model.Patient;
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

    public List<PatientDto> getPatients() {
        return patientRepository.findAll()
                .stream()
                .map(PatientMapping::toDto)
                .collect(Collectors.toList());
    }

    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        return PatientMapping.toDto(patient);
    }

    public List<PatientDto> searchPatients(String searchString) {

        List<Patient> patients = patientRepository.searchPatients(searchString);

        return patients.stream()
                .map(PatientMapping::toDto)
                .collect(Collectors.toList());
    }

    public PatientDto createPatient(PatientDto patientDto) {
        if(patientDto == null) {
            throw new IllegalArgumentException("Patient data must not be null");
        }
        Patient patient = PatientMapping.toEntity(patientDto);
        patientRepository.save(patient);
        return patientDto;
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


    public PatientDto updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto) {
        if(id == null) {
            throw new IllegalArgumentException("Patient id must not be null");
        }

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found with id: " + id));
        patient.setPatientId(id);
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setEmail(patientDto.getEmail());

        if (patientDto.getAddress() != null) {
            Address address = patient.getAddress();
            if (address == null) {
                address = new Address();
            }
            address.setLocation(patientDto.getAddress().getLocation());
            patient.setAddress(address);
        }
        patientRepository.save(patient);

        return patientDto;
    }

}
