package lab6.cs489.appointmentMngt.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
@Tag(name = "Addresses", description = "APIs for managing addresses")
public class AddressController {
}
