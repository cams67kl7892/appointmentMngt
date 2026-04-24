package lab6.cs489.appointmentMngt.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lab6.cs489.appointmentMngt.dto.DentistDto;
import lab6.cs489.appointmentMngt.service.DentistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Dentists", description = "APIs for managing dentists")
public class DentistController {

    private final DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }


    @PostMapping("/dentist")
    public ResponseEntity<DentistDto> createDentist(@RequestBody DentistDto dentistDto) {
        dentistService.createDentist(dentistDto);
        return ResponseEntity.status(201).body(dentistDto);
    }

    @GetMapping("/dentists")
    public ResponseEntity<List<DentistDto>> getDentists() {
        return ResponseEntity.status(200).body(dentistService.getAllDentists());
    }

    @GetMapping("/dentist/{id}")
    public ResponseEntity<DentistDto> getDentistById(@PathParam("id") Long id) {
        return ResponseEntity.ok(dentistService.getDentistById(id));
    }

}
