package lab6.cs489.appointmentMngt.Adapter;

import lab6.cs489.appointmentMngt.dto.DentistDto;
import lab6.cs489.appointmentMngt.model.Dentist;

public class DentistMapping {

    public static DentistDto toDto(Dentist dentist) {
        if(dentist == null) {
            return null;
        }
        DentistDto dentistDto = new DentistDto();
        dentistDto.setDentistId(dentist.getDentistId());
        dentistDto.setFirstName(dentist.getFirstName());
        dentistDto.setLastName(dentist.getLastName());
        dentistDto.setPhoneNumber(dentist.getPhoneNumber());
        return dentistDto;
    }

    public static Dentist toEntity(DentistDto dentistDto) {
        if(dentistDto == null) {
            return null;
        }
        Dentist dentist = new Dentist();
        dentist.setDentistId(dentistDto.getDentistId());
        dentist.setFirstName(dentistDto.getFirstName());
        dentist.setPhoneNumber(dentistDto.getPhoneNumber());
        return dentist;
    }
}
