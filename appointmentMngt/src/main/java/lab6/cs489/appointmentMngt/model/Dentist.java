package lab6.cs489.appointmentMngt.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @NotNull
    private String  firstName;
    @NotNull
    private String lastName;
    private String phoneNumber;
    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointmentList;
}
