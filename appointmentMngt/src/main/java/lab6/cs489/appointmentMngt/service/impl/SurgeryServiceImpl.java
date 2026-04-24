package lab6.cs489.appointmentMngt.service.impl;

import lab6.cs489.appointmentMngt.Adapter.SurgeryMapping;
import lab6.cs489.appointmentMngt.AddressMapping;
import lab6.cs489.appointmentMngt.dto.SurgeryDto;
import lab6.cs489.appointmentMngt.model.Surgery;
import lab6.cs489.appointmentMngt.repository.SurgeryRepository;
import lab6.cs489.appointmentMngt.service.SurgeryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    private final SurgeryRepository surgeryRepository;

    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public SurgeryDto createSurgery(SurgeryDto surgeryDto) {
        if(surgeryDto ==null) {
            throw new IllegalArgumentException("Surgery data cannot be null");
        }
        Surgery surgery = new Surgery();
        surgery.setSurgeryId(surgeryDto.getSurgeryId());
        surgery.setName(surgeryDto.getName());
        surgery.setPhoneNumber(surgeryDto.getPhoneNumber());
        if(surgeryDto.getAddress() != null) {
            surgery.setAddress(AddressMapping.toEntity(surgeryDto.getAddress()));
        }
        surgeryRepository.save(surgery);
        return surgeryDto;
    }

    @Override
    public SurgeryDto getSurgeryById(Long id) {
            Surgery surgery = surgeryRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Surgery not found with id: " + id));
        return SurgeryMapping.toDto(surgery);
    }

    @Override
    public List<SurgeryDto> getAllSurgeries() {
        return surgeryRepository.findAll()
                .stream()
                .map(SurgeryMapping::toDto)
                .toList();
    }
}
