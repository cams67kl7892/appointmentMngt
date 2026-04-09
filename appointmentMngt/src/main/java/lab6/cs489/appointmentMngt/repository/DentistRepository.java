package lab6.cs489.appointmentMngt.repository;

import lab6.cs489.appointmentMngt.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
