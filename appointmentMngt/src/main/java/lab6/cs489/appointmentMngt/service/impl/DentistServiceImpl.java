package lab6.cs489.appointmentMngt.service.impl;

import lab6.cs489.appointmentMngt.Adapter.DentistMapping;
import lab6.cs489.appointmentMngt.dto.DentistDto;
import lab6.cs489.appointmentMngt.model.Dentist;
import lab6.cs489.appointmentMngt.repository.DentistRepository;
import lab6.cs489.appointmentMngt.service.DentistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DentistServiceImpl implements DentistService {

    private DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public DentistDto createDentist(DentistDto dentistDto) {
        if(dentistDto == null) {
            throw new IllegalArgumentException("Dentist data cannot be null");
        }

        Dentist dentist = new Dentist();
        dentist.setDentistId(dentistDto.getDentistId());
        dentist.setFirstName(dentistDto.getFirstName());
        dentist.setLastName(dentistDto.getLastName());
        log.info("Creating dentist: {} {}", dentist.getFirstName(), dentist.getLastName());
        dentist.setPhoneNumber(dentistDto.getPhoneNumber());

        dentistRepository.save(dentist);
        return dentistDto;
    }

    @Override
    public DentistDto getDentistById(Long id) {
        return dentistRepository.findById(id)
                .map(DentistMapping::toDto)
                .orElseThrow(() -> new RuntimeException("Dentist not found with id: " + id));
    }

    @Override
    public List<DentistDto> getAllDentists() {
        return dentistRepository.findAll()
                .stream()
                .map(DentistMapping::toDto)
                .toList();
    }

    @Override
    public DentistDto updateDentist(Long id, DentistDto dentistDto) {
        return null;
    }

    @Override
    public String deleteDentist(Long id) {
        return "";
    }

    @Override
    public DentistDto searchDentist(String keyword) {
        return null;
    }
}
