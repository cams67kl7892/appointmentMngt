package lab6.cs489.appointmentMngt.service;

import lab6.cs489.appointmentMngt.dto.SurgeryDto;
import lab6.cs489.appointmentMngt.repository.SurgeryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SurgeryService {

    public SurgeryDto createSurgery(SurgeryDto surgeryDto);

    public SurgeryDto getSurgeryById(Long id);

    public List<SurgeryDto> getAllSurgeries();

}
