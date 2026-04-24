package lab6.cs489.appointmentMngt.Adapter;

import lab6.cs489.appointmentMngt.AddressMapping;
import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.model.Patient;

public class PatientMapping {

    public static Patient toEntity(PatientDto patientDto) {
        if(patientDto == null) {
            return null;
        }
        Patient patient = new Patient();
        patient.setPatientId(patientDto.getPatientId());
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setEmail(patientDto.getEmail());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        if(patientDto.getAddress() != null) {
            patient.setAddress(AddressMapping.toEntity(patientDto.getAddress()));
        }
        return patient;
    }

    public static PatientDto toDto(Patient patient) {
        if(patient == null) {
            return null;
        }
        PatientDto dto = new PatientDto();
        dto.setPatientId(patient.getPatientId());
        dto.setLastName(patient.getLastName());
        dto.setFirstName(patient.getFirstName());
        dto.setEmail(patient.getEmail());
        dto.setPhoneNumber(patient.getPhoneNumber());
        if(patient.getAddress() != null) {
            dto.setAddress(AddressMapping.toDto(patient.getAddress()));
        }
        return dto;
    }

}
