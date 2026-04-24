package lab6.cs489.appointmentMngt.service.impl;

import lab6.cs489.appointmentMngt.Adapter.AppointmentMapping;
import lab6.cs489.appointmentMngt.Adapter.DentistMapping;
import lab6.cs489.appointmentMngt.Adapter.PatientMapping;
import lab6.cs489.appointmentMngt.Adapter.SurgeryMapping;
import lab6.cs489.appointmentMngt.dto.AppointmentDto;
import lab6.cs489.appointmentMngt.dto.AppointmentPageDto;
import lab6.cs489.appointmentMngt.model.Appointment;
import lab6.cs489.appointmentMngt.model.Dentist;
import lab6.cs489.appointmentMngt.model.Patient;
import lab6.cs489.appointmentMngt.model.Surgery;
import lab6.cs489.appointmentMngt.repository.AppointmentRepository;
import lab6.cs489.appointmentMngt.repository.DentistRepository;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import lab6.cs489.appointmentMngt.repository.SurgeryRepository;
import lab6.cs489.appointmentMngt.requestDto.AppointmentRequestDto;
import lab6.cs489.appointmentMngt.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DentistRepository dentistRepository;
    private final SurgeryRepository surgeryRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository,
                                  DentistRepository dentistRepository, SurgeryRepository surgeryRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.dentistRepository = dentistRepository;
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public AppointmentPageDto getAppointments(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Appointment> appointmentPage = appointmentRepository.findAll(pageable);

        return new AppointmentPageDto(appointmentPage);
    }

    @Override
    public AppointmentDto getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .map(AppointmentMapping::toDto)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    @Override
    @Transactional
    public AppointmentDto createAppointment(AppointmentRequestDto appointmentDto) {

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentDto.getAppointmentTime());

        if(appointmentDto.getSurgeryId() != null) {
            appointment.setSurgery(null);
            Surgery surgery = surgeryRepository.findById(appointmentDto.getSurgeryId())
                    .orElseThrow(() -> new RuntimeException("Surgery not found with id: " + appointmentDto.getSurgeryId()));
            appointment.setSurgery(surgery);
        }
        if(appointmentDto.getDentistId() != null) {
            Dentist dentist = dentistRepository.findById(appointmentDto.getDentistId())
                    .orElseThrow(() -> new RuntimeException("Dentist not found with id: " + appointmentDto.getDentistId()));
            appointment.setDentist(dentist);
        }
       if(appointmentDto.getPatientId()!= null) {
           Patient patient = patientRepository.findById(appointmentDto.getPatientId())
                   .orElseThrow(() -> new RuntimeException("Patient not found with id: " + appointmentDto.getPatientId()));
           appointment.setPatient(patient);
       }
        appointmentRepository.save(appointment);

        return AppointmentMapping.toDto(appointment);
    }

    @Override
    public String deleteAppointment(Long id) {
        return "";
    }

    @Override
    public AppointmentDto updateAppointment(Long id, AppointmentDto dto) {
        return null;
    }


    @Override
    public List<AppointmentDto> searchAppointment(LocalDate date) {
        return appointmentRepository.searchAppointments(date)
                .stream()
                .map(AppointmentMapping::toDto)
                .toList();
    }

}
