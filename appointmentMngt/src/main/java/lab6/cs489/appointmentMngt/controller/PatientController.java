package lab6.cs489.appointmentMngt.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.repository.AddressRepository;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import lab6.cs489.appointmentMngt.service.PatientService;
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

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Patients", description = "APIs for managing patients")
public class PatientController {

  private final PatientService patientService;

    public PatientController(PatientRepository patientRepository, AddressRepository addressRepository,
                             PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDto>> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
        patientService.createPatient(patientDto);
        return  ResponseEntity.status(201).body(patientDto);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
     return ResponseEntity.status(204).body("Patient deleted successfully");
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id, @RequestBody PatientDto dto) {
        return ResponseEntity.status(200).body(patientService.updatePatient(id, dto));
    }

    @GetMapping("patients/{searchString}")
    public ResponseEntity<List<PatientDto>> searchPatients(@PathVariable String searchString) {
        return ResponseEntity.ok(patientService.searchPatients(searchString));
    }
}
