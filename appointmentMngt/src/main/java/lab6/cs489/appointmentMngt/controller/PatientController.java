package lab6.cs489.appointmentMngt.controller;


import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.exceptions.ResourceNotFoundException;
import lab6.cs489.appointmentMngt.model.Address;
import lab6.cs489.appointmentMngt.model.Patient;
import lab6.cs489.appointmentMngt.repository.AddressRepository;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import lab6.cs489.appointmentMngt.service.PatientService;
import lab6.cs489.appointmentMngt.service.impl.PatientServiceImpl;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
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


@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

//  private final PatientRepository patientRepository;
//  private final AddressRepository addressRepository;
  private final PatientService patientService;

    public PatientController(PatientRepository patientRepository, AddressRepository addressRepository, PatientServiceImpl patientService) {
//        this.patientRepository = patientRepository;
//        this.addressRepository = addressRepository;
        this.patientService = patientService;
    }

    @GetMapping("")
    public List<PatientDto> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/{id}")
    public PatientDto getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("")
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto dto) {
        PatientDto patientDto = patientService.createPatient(dto);
        return  ResponseEntity.ok(patientDto);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
     return "Patient deleted successfully";
    }

    @PutMapping("/{id}")
    public PatientDto updatePatient(@PathVariable Long id, @RequestBody PatientDto dto) {
        return patientService.updatePatient(id, dto);
    }

    @GetMapping("search/{searchString}")
    public List<PatientDto> searchPatients(@PathVariable String searchString) {
        return patientService.searchPatients(searchString);
    }
}
