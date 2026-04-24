package lab6.cs489.appointmentMngt;

import lab6.cs489.appointmentMngt.dto.AddressDto;
import lab6.cs489.appointmentMngt.model.Address;

public class AddressMapping {

    public static Address toEntity(AddressDto addressDto) {

        if (addressDto == null) {
            return null;
        }
        Address address = new Address();
        address.setAddressId(addressDto.getAddressId());
        address.setLocation(addressDto.getLocation());
        return address;
    }

    public static AddressDto toDto(Address address) {

        if (address == null) {
            return null;
        }
        AddressDto addressDto = new AddressDto();
        addressDto.setAddressId(address.getAddressId());
        addressDto.setLocation(address.getLocation());
        return addressDto;
    }
}
