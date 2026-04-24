package lab6.cs489.appointmentMngt.service;

import lab6.cs489.appointmentMngt.dto.DentistDto;
import lab6.cs489.appointmentMngt.repository.DentistRepository;

import java.util.List;

public interface DentistService {

    public DentistDto createDentist(DentistDto dentistDto);

    public DentistDto getDentistById(Long id);

    public List<DentistDto> getAllDentists();

    public DentistDto updateDentist(Long id, DentistDto dentistDto);

    public String deleteDentist(Long id);

    public DentistDto searchDentist(String keyword);
}
