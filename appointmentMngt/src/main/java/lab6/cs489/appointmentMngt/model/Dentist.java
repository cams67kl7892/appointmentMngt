package lab6.cs489.appointmentMngt.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_dentist")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dentistId;
    @Nonnull
    private String  firstName;
    @Nonnull
    private String lastName;
    private String phoneNumber;
}
