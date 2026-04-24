package lab6.cs489.appointmentMngt.Adapter;

import lab6.cs489.appointmentMngt.AddressMapping;
import lab6.cs489.appointmentMngt.dto.SurgeryDto;
import lab6.cs489.appointmentMngt.model.Surgery;

public class SurgeryMapping {


    public static SurgeryDto toDto(Surgery surgery) {
        if(surgery == null) {
            return null;
        }
        SurgeryDto surgeryDto = new SurgeryDto();
        surgeryDto.setSurgeryId(surgery.getSurgeryId());
        surgeryDto.setName(surgery.getName());
        surgeryDto.setPhoneNumber(surgery.getPhoneNumber());
        if(surgery.getAddress() != null) {
            surgeryDto.setAddress(AddressMapping.toDto(surgery.getAddress()));
        }
        return surgeryDto;
    }

    public static Surgery toEntity(SurgeryDto surgeryDto) {
        if(surgeryDto == null) {
            return null;
        }
        Surgery surgery = new Surgery();
        surgery.setSurgeryId(surgeryDto.getSurgeryId());
        surgery.setName(surgeryDto.getName());
        surgery.setPhoneNumber(surgeryDto.getPhoneNumber());
        surgery.setAddress(new AddressMapping().toEntity(surgeryDto.getAddress()));
        return surgery;
    }
}
