package lab6.cs489.appointmentMngt;

import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.model.Address;
import lab6.cs489.appointmentMngt.model.Patient;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import lab6.cs489.appointmentMngt.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class PatientServiceIntegrationTest {

        @Autowired
        private PatientService patientService;

        @Autowired
        private PatientRepository patientRepository;

        private Patient savedPatient;

        @BeforeEach
        void setUp() {
            Address address = new Address();
            address.setLocation("123 Main St");
            savedPatient = new Patient();
            savedPatient.setFirstName("John");
            savedPatient.setLastName("Doe");
            savedPatient.setAddress(address);
            savedPatient.getAppointmentList().add(null); // Add a dummy appointment if needed

            savedPatient = patientRepository.save(savedPatient);
        }

        @Test
        void testFindPatientById_ValidId() {
            PatientDto result = patientService.getPatientById(savedPatient.getPatientId());

            assertNotNull(result);
            assertEquals("John", result.getFirstName());
        }

        @Test
        void testFindPatientById_InvalidId() {
            PatientDto result = patientService.getPatientById(999L); // Assuming 999L does not exist

            assertNull(result); // OR assertThrows if you use exception
        }
    }


