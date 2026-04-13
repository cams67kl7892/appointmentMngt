package lab6.cs489.appointmentMngt.controller;


import lab6.cs489.appointmentMngt.dto.AddressDto;
import lab6.cs489.appointmentMngt.dto.AppointmentDto;
import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.exceptions.ResourceNotFoundException;
import lab6.cs489.appointmentMngt.model.Address;
import lab6.cs489.appointmentMngt.model.Patient;
import lab6.cs489.appointmentMngt.repository.AddressRepository;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import lab6.cs489.appointmentMngt.service.PatientService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

  private final PatientRepository patientRepository;
  private final AddressRepository addressRepository;
  private final PatientService patientService;

    public PatientController(PatientRepository patientRepository, AddressRepository addressRepository, PatientService patientService) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
        this.patientService = patientService;
    }

    @GetMapping("")
    public List<PatientDto> getPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id);
    }

    @PostMapping("")
    public PatientDto createPatient(@RequestBody PatientDto dto) {
        Patient patient = new Patient();
        patient.setFistName(dto.getFistName());
        patient.setLastName(dto.getLastName());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setEmail(dto.getEmail());

        if (dto.getAddress() != null) {
            Address address = new Address();
            address.setLocation(dto.getAddress().getLocation());
            addressRepository.save(address);
            patient.setAddress(address);
        }

        Patient saved = patientRepository.save(patient);

        return convertToDto(saved);
    }

    @DeleteMapping("/{id}")
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

    @PutMapping("/{id}")
    public PatientDto updatePatient(@PathVariable Long id, @RequestBody PatientDto dto) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found with id: " + id));

        // update fields
        patient.setPatientId(id);
        patient.setFistName(dto.getFistName());
        patient.setLastName(dto.getLastName());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setEmail(dto.getEmail());

        // update address
        if (dto.getAddress() != null) {

            Address address = patient.getAddress();

            if (address == null) {
                address = new Address();
            }

            address.setLocation(dto.getAddress().getLocation());
            patient.setAddress(address);
        }

        Patient updated = patientRepository.save(patient);

        return convertToDto(updated);
    }

    @GetMapping("search/{searchString}")
    public List<PatientDto> searchPatients(@PathVariable String searchString) {
        return patientService.searchPatients(searchString);
    }


    public PatientDto convertToDto(Patient patient) {

        PatientDto dto = new PatientDto();
        dto.setFistName(patient.getFistName());
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
