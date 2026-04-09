package lab6.cs489.appointmentMngt.repository;

import lab6.cs489.appointmentMngt.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
