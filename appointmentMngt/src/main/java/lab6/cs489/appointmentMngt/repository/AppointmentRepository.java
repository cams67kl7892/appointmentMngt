package lab6.cs489.appointmentMngt.repository;

import lab6.cs489.appointmentMngt.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
