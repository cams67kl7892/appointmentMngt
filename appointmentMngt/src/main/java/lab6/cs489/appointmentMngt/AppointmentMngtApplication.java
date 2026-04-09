package lab6.cs489.appointmentMngt;

import lab6.cs489.appointmentMngt.model.Address;
import lab6.cs489.appointmentMngt.repository.AddressRepository;
import lab6.cs489.appointmentMngt.repository.AppointmentRepository;
import lab6.cs489.appointmentMngt.repository.DentistRepository;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import lab6.cs489.appointmentMngt.repository.RoleRepository;
import lab6.cs489.appointmentMngt.repository.SurgeryRepository;
import lab6.cs489.appointmentMngt.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.yaml.snakeyaml.tokens.DocumentEndToken;

@SpringBootApplication
public class AppointmentMngtApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppointmentMngtApplication.class, args);

	}

	@Bean
	CommandLineRunner init(AddressRepository addressRepository, DentistRepository dentistRepository,
						   PatientRepository patientRepository, SurgeryRepository surgeryRepository,
						   AppointmentRepository appointmentRepository, UserRepository userRepository,
						   RoleRepository roleRepository) {
		return args -> {
			Address address = new Address();
			address.setLocation("Fairfield, IA");

			addressRepository.save(address);
			System.out.println("Address saved: " + address.getLocation());
		};
	}

}
