package lab6.cs489.appointmentMngt.Adapter;

import lab6.cs489.appointmentMngt.dto.AddressDto;
import lab6.cs489.appointmentMngt.dto.AppointmentDto;
import lab6.cs489.appointmentMngt.dto.DentistDto;
import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.dto.SurgeryDto;
import lab6.cs489.appointmentMngt.model.Appointment;

public class AppointmentMapping {

    public static AppointmentDto toDto(Appointment a) {
        AppointmentDto dto = new AppointmentDto();

        // ✔ primitive fields only
        dto.setAppointmentId(a.getAppointmentId());
        dto.setAppointmentDate(a.getAppointmentDate());
        dto.setAppointmentTime(a.getAppointmentTime());

        PatientDto patientDto = new PatientDto();
        if(a.getPatient() != null) {
            patientDto.setPatientId(a.getPatient().getPatientId());
            patientDto.setFirstName(a.getPatient().getFirstName());
            patientDto.setLastName(a.getPatient().getLastName());
            patientDto.setEmail(a.getPatient().getEmail());
            patientDto.setPhoneNumber(a.getPatient().getPhoneNumber());
        }

        AddressDto addressDto = new AddressDto();
        if(a.getPatient() != null && a.getPatient().getAddress() != null) {
            addressDto.setAddressId(a.getPatient().getAddress().getAddressId());
            addressDto.setLocation(a.getPatient().getAddress().getLocation());
        }
        patientDto.setAddress(addressDto);

        dto.setPatient(patientDto);

        DentistDto dentistDto = new DentistDto();
        if(a.getDentist() != null) {
            dentistDto.setDentistId(a.getDentist().getDentistId());
            dentistDto.setFirstName(a.getDentist().getFirstName());
            dentistDto.setLastName(a.getDentist().getLastName());
            dentistDto.setPhoneNumber(a.getDentist().getPhoneNumber());
            dto.setDentist(dentistDto);
        }

        SurgeryDto surgeryDto = new SurgeryDto();
        if(a.getSurgery() != null) {
            surgeryDto.setSurgeryId(a.getSurgery().getSurgeryId());
            surgeryDto.setName(a.getSurgery().getName());
            surgeryDto.setPhoneNumber(a.getSurgery().getPhoneNumber());
            AddressDto addressDto2 = new AddressDto();
            addressDto2.setAddressId(a.getPatient().getAddress().getAddressId());
            addressDto2.setLocation(a.getPatient().getAddress().getLocation());
            surgeryDto.setAddress(addressDto2);
        }

        dto.setSurgery(surgeryDto);

        return dto;

    }

    private static Appointment toEntity(AppointmentDto appointmentDto) {

        if(appointmentDto == null) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setAppointmentId(appointmentDto.getAppointmentId());
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
        appointment.setSurgery(SurgeryMapping.toEntity(appointmentDto.getSurgery()));
        appointment.setDentist(DentistMapping.toEntity(appointmentDto.getDentist()));
        appointment.setPatient(PatientMapping.toEntity(appointmentDto.getPatient()));

        return appointment;
    }
}
