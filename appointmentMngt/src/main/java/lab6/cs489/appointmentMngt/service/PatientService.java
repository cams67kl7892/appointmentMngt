package lab6.cs489.appointmentMngt.service;

import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.model.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface PatientService {

    public List<PatientDto> getPatients();

    public PatientDto getPatientById(Long id);

    public List<PatientDto> searchPatients(String searchString);

    public PatientDto convertToDto(Patient patient);

    public PatientDto createPatient(PatientDto dto);

    public String deletePatient(Long id);

    public PatientDto updatePatient(Long id, PatientDto dto);
}
