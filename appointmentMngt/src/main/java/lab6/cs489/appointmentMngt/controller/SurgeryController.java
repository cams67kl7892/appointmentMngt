package lab6.cs489.appointmentMngt.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lab6.cs489.appointmentMngt.dto.SurgeryDto;
import lab6.cs489.appointmentMngt.service.SurgeryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Surgeries", description = "APIs for managing Surgeries")
public class SurgeryController {

    private final SurgeryService surgeryService;

    public SurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @PostMapping("/surgery")
    public ResponseEntity<SurgeryDto> createSurgery(@RequestBody SurgeryDto surgeryDto) {
        if(surgeryDto == null) {
            throw new IllegalArgumentException("Surgery data cannot be null");
        }
        surgeryService.createSurgery(surgeryDto);
        return ResponseEntity.status(201).body(surgeryDto);
    }

    @GetMapping("/surgery/{id}")
    public ResponseEntity<SurgeryDto> getSurgeryById(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Surgery ID cannot be null");
        }
        return ResponseEntity.ok(surgeryService.getSurgeryById(id));
    }

    @GetMapping("/surgeries")
    public ResponseEntity<List<SurgeryDto>> getAllSurgeries() {
        return ResponseEntity.ok(surgeryService.getAllSurgeries());
    }


}
