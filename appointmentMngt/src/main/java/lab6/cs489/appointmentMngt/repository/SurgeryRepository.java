package lab6.cs489.appointmentMngt.repository;

import lab6.cs489.appointmentMngt.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
