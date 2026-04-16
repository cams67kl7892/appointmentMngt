package lab6.cs489.appointmentMngt;

import lab6.cs489.appointmentMngt.model.Address;
import lab6.cs489.appointmentMngt.model.Appointment;
import lab6.cs489.appointmentMngt.model.Dentist;
import lab6.cs489.appointmentMngt.model.Patient;
import lab6.cs489.appointmentMngt.model.Role;
import lab6.cs489.appointmentMngt.model.Surgery;
import lab6.cs489.appointmentMngt.model.User;
import lab6.cs489.appointmentMngt.repository.AddressRepository;
import lab6.cs489.appointmentMngt.repository.AppointmentRepository;
import lab6.cs489.appointmentMngt.repository.DentistRepository;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import lab6.cs489.appointmentMngt.repository.RoleRepository;
import lab6.cs489.appointmentMngt.repository.SurgeryRepository;
import lab6.cs489.appointmentMngt.repository.UserRepository;
import lab6.cs489.appointmentMngt.service.UserService;
import lab6.cs489.appointmentMngt.service.impl.CustomUserDetailsService;
import lab6.cs489.appointmentMngt.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.yaml.snakeyaml.tokens.DocumentEndToken;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AppointmentMngtApplication {

	//private UserServiceImpl userService;

	public static void main(String[] args) {

		SpringApplication.run(AppointmentMngtApplication.class, args);


	}

	@Bean
	CommandLineRunner init(AddressRepository addressRepository, DentistRepository dentistRepository,
						   PatientRepository patientRepository, SurgeryRepository surgeryRepository,
						   AppointmentRepository appointmentRepository, UserRepository userRepository,
						   RoleRepository roleRepository) {
		return args -> {
//			Role adminRole = new Role();
//			adminRole.setRoleName("ADMIN");
//
//			Role dentistRole = new Role();
//			dentistRole.setRoleName("DENTIST");
//
//			Role patientRole = new Role();
//			patientRole.setRoleName("PATIENT");
//
//			roleRepository.saveAll(List.of(adminRole, dentistRole, patientRole));
//
//			User admin = new User();
//			admin.setFirstName("Admin");
//			admin.setLastName("User");
//			admin.setUserName("admin");
//			admin.setPassword(passwordEncoder.encode("admin123"));
//
//			admin.setRoleList(Set.of(adminRole));
//
//			userRepository.save(admin);
			// User user = new User(1, "John", "Doe", "john123", "john123", null);
			// userRepository.save(user);
			// System.out.println(userService.findByUserName("john123"));
//			 saveAddress(addressRepository);
//		     savePatient(patientRepository, addressRepository);
//		saveSurgery(surgeryRepository, addressRepository);
//			saveDentist(dentistRepository);
//			saveAppointment(appointmentRepository, addressRepository, surgeryRepository, patientRepository,
//					dentistRepository);
//			saveUserRole(userRepository, roleRepository);
		};
	}

    public static void saveAddress(AddressRepository addressRepository) {
		Address address = new Address();
		address.setLocation("Fairfield, IA");
		Address address1 = new Address();
		address1.setLocation("2 Av, Detroit");
		Address address2 = new Address();
		address2.setLocation("Grand Junction, CO");

		addressRepository.save(address1);
		addressRepository.save(address2);
	}

	public static void savePatient(PatientRepository patientRepository, AddressRepository addressRepository) {
		Address address = new Address();
		address.setLocation("Springfield, IA");
		addressRepository.save(address);

		Patient patient = new Patient();
		patient.setFistName("Alan");
		patient.setLastName("Smith");
		patient.setPhoneNumber("1234567890");
		patient.setEmail("p2@gmail.com");
		patient.setAddress(address);

		patientRepository.save(patient);
	}

	public static void saveSurgery(SurgeryRepository surgeryRepository, AddressRepository addressRepository) {
		Address address = new Address();
		address.setLocation("31th street manhattan, ny");
		addressRepository.save(address);
		Surgery surgery = new Surgery();
		surgery.setAddress(address);
		surgery.setPhoneNumber("7129028210");
		surgery.setName("S91_773U");
		surgeryRepository.save(surgery);
	}

	public static void saveDentist(DentistRepository dentistRepository) {
		Dentist dentist = new Dentist();
		dentist.setFirstName("Omar");
		dentist.setLastName("Bensaki");
		dentist.setPhoneNumber("2558912230");
		dentistRepository.save(dentist);
	}

	public static void saveAppointment(AppointmentRepository appointmentRepository
			, AddressRepository addressRepository, SurgeryRepository surgeryRepository, PatientRepository patientRepository,
									   DentistRepository dentistRepository) {
		Address address = new Address();
		address.setLocation("Burlington av");
		addressRepository.save(address);

		Surgery surgery = new Surgery();
		surgery.setName("S19882U");
		surgery.setAddress(address);
		surgeryRepository.save(surgery);

		Patient patient = new Patient();
		patient.setFistName("susan");
		patient.setLastName("lagardia");
		patient.setAddress(address);
		patientRepository.save(patient);

		Dentist dentist = new Dentist();
		dentist.setFirstName("Camille");
		dentist.setLastName("Hernandez");
		dentistRepository.save(dentist);

		Appointment appointment = new Appointment();
		appointment.setAppointmentDate(LocalDate.of(2026, 12, 11));
		appointment.setAppointmentTime(LocalTime.of(12, 0));
		appointment.setPatient(patient);
		appointment.setSurgery(surgery);
		appointment.setDentist(dentist);

		appointmentRepository.save(appointment);
	}


	public static void saveUserRole(UserRepository userRepository, RoleRepository roleRepository) {
		User user = new User();
		user.setUserName("JK912U");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setPassword("password");


		Role managerRole = new Role();
		managerRole.setRoleName("Manager");
		Role hrRole = new Role();
		hrRole.setRoleName("HR");
		roleRepository.save(managerRole);
		roleRepository.save(hrRole);

		Set<Role> roles = new HashSet<>();
		roles.add(managerRole);
		roles.add(hrRole);
		user.setRoleList(roles);

		userRepository.save(user);

	}
}


