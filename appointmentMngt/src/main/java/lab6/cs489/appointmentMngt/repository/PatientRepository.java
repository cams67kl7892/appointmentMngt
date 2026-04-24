package lab6.cs489.appointmentMngt.repository;

import lab6.cs489.appointmentMngt.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT p FROM Patient p " +
            "WHERE LOWER(p.lastName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(p.firstName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(p.email) LIKE LOWER(CONCAT('%', :search, '%'))" +
             "OR LOWER(p.phoneNumber) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Patient> searchPatients(@Param("search") String search);

}
