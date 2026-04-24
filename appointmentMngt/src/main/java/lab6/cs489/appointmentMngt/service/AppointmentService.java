package lab6.cs489.appointmentMngt.service;

import lab6.cs489.appointmentMngt.dto.AppointmentDto;
import lab6.cs489.appointmentMngt.dto.AppointmentPageDto;
import lab6.cs489.appointmentMngt.requestDto.AppointmentRequestDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

   public AppointmentPageDto getAppointments(int page, int size);

   public AppointmentDto getAppointmentById(Long id);

   public AppointmentDto createAppointment(AppointmentRequestDto dto);

   public String deleteAppointment(Long id);

   public AppointmentDto updateAppointment(Long id, AppointmentDto dto);

   public List<AppointmentDto> searchAppointment(LocalDate search);

}
