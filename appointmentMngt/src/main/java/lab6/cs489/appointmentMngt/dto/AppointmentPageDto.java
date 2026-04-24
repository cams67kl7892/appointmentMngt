package lab6.cs489.appointmentMngt.dto;

import lab6.cs489.appointmentMngt.Adapter.AppointmentMapping;
import lab6.cs489.appointmentMngt.model.Appointment;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class AppointmentPageDto {
    private List<AppointmentDto> content;
    private int totalPages;
    private long totalElements;
    private int currentPage;
    private int pageSize;

    public AppointmentPageDto(Page<Appointment> page) {
        this.content = page.getContent()
                .stream()
                .map(AppointmentMapping::toDto)
                .toList();

        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.currentPage = page.getNumber();
        this.pageSize = page.getSize();
    }
}
