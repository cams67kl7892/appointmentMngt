package lab6.cs489.appointmentMngt.service;

import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.model.Patient;

import java.util.List;


public interface PatientService {

    public List<PatientDto> getPatients();

    public PatientDto getPatientById(Long id);

    public List<PatientDto> searchPatients(String searchString);

    public PatientDto createPatient(PatientDto dto);

    public String deletePatient(Long id);

    public PatientDto updatePatient(Long id, PatientDto dto);
}
