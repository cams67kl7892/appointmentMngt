package lab6.cs489.appointmentMngt.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lab6.cs489.appointmentMngt.dto.AppointmentDto;
import lab6.cs489.appointmentMngt.dto.AppointmentPageDto;
import lab6.cs489.appointmentMngt.repository.AppointmentRepository;
import lab6.cs489.appointmentMngt.repository.DentistRepository;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import lab6.cs489.appointmentMngt.repository.SurgeryRepository;
import lab6.cs489.appointmentMngt.requestDto.AppointmentRequestDto;
import lab6.cs489.appointmentMngt.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.net.URI;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
@Tag(name = "Appointments", description = "APIs for managing appointments")
public class AppointmentController {

  private AppointmentService appointmentService;

  public AppointmentController(AppointmentRepository appointmentRepository,
                               AppointmentService  appointmentService, PatientRepository patientRepository,
                               DentistRepository dentistRepository, SurgeryRepository surgeryRepository) {
      this.appointmentService = appointmentService;
  }

  @GetMapping("/appointments")
  public ResponseEntity<AppointmentPageDto> getAppointments(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "5") int size
  ) {
      Pageable pageable = PageRequest.of(page, size);
      return ResponseEntity.ok()
              .body(appointmentService.getAppointments(pageable.getPageNumber(), pageable.getPageSize()));
  }

  @GetMapping("appointment/{id}")
  public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id) {
      return ResponseEntity.ok(appointmentService.getAppointmentById(id));
  }

  @PostMapping("appointment")
  public ResponseEntity<AppointmentRequestDto> createAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) {
      appointmentService.createAppointment(appointmentRequestDto);
      return ResponseEntity.status(201).body(appointmentRequestDto);
  }

  @GetMapping("/appointments/{date}")
  public ResponseEntity<List<AppointmentDto>> searchAppointment(@PathVariable LocalDate date) {
      return ResponseEntity.ok().body(appointmentService.searchAppointment(date));
  }


  @DeleteMapping("appointment/{id}")
  public String deleteAppointment(Long id) {
      return "Appointment deleted successfully";
  }

  @PutMapping("appointment/{id}")
  public AppointmentDto updateAppointment(Long id, AppointmentDto dto) {
      return null;
  }

}
