package lab6.cs489.appointmentMngt.data;


import lab6.cs489.appointmentMngt.model.Address;
import lab6.cs489.appointmentMngt.model.Appointment;
import lab6.cs489.appointmentMngt.model.Dentist;
import lab6.cs489.appointmentMngt.model.Patient;
import lab6.cs489.appointmentMngt.model.Role;
import lab6.cs489.appointmentMngt.model.Surgery;
import lab6.cs489.appointmentMngt.model.User;
import lab6.cs489.appointmentMngt.repository.AppointmentRepository;
import lab6.cs489.appointmentMngt.repository.DentistRepository;
import lab6.cs489.appointmentMngt.repository.PatientRepository;
import lab6.cs489.appointmentMngt.repository.RoleRepository;
import lab6.cs489.appointmentMngt.repository.SurgeryRepository;
import lab6.cs489.appointmentMngt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class Data {

   private PatientRepository patientRepository;
   private DentistRepository dentistRepository;
   private SurgeryRepository surgeryRepository;
   private AppointmentRepository appointmentRepository;
   private RoleRepository roleRepository;
   private UserRepository userRepository;
   private PasswordEncoder passwordEncoder;

   @Bean
   CommandLineRunner initDatabase() {
       return args -> {
         // saveAppointment();
         // saveUserAndRole();
       };
    }

   public void saveAppointment() {

      // ===================== RECORD 1 =====================
      Patient patient1 = new Patient();
      patient1.setFirstName("John");
      patient1.setEmail("john@gmail.com");
      patient1.setLastName("Doe");
      patient1.setPhoneNumber("1234567890");

      Address addr1 = new Address();
      addr1.setLocation("123 Main St");
      patient1.setAddress(addr1);
      patientRepository.save(patient1);

      Dentist dentist1 = new Dentist();
      dentist1.setFirstName("Sarah");
      dentist1.setLastName("Smith");
      dentist1.setPhoneNumber("1111111111");
      dentistRepository.save(dentist1);

      Surgery surgery1 = new Surgery();
      surgery1.setName("Dental Care Center");
      surgery1.setPhoneNumber("2222222222");

      Address saddr1 = new Address();
      saddr1.setLocation("456 Elm St");
      surgery1.setAddress(saddr1);
      surgeryRepository.save(surgery1);

      Appointment a1 = new Appointment();
      a1.setAppointmentDate(java.time.LocalDate.now());
      a1.setAppointmentTime(java.time.LocalTime.now());
      a1.setPatient(patient1);
      a1.setDentist(dentist1);
      a1.setSurgery(surgery1);
      appointmentRepository.save(a1);

      // ===================== RECORD 2 =====================
      Patient patient2 = new Patient();
      patient2.setFirstName("Alice");
      patient2.setEmail("alice@gmail.com");
      patient2.setLastName("Brown");
      patient2.setPhoneNumber("2223334444");

      Address addr2 = new Address();
      addr2.setLocation("789 Oak St");
      patient2.setAddress(addr2);
      patientRepository.save(patient2);

      Dentist dentist2 = new Dentist();
      dentist2.setFirstName("Michael");
      dentist2.setLastName("Johnson");
      dentist2.setPhoneNumber("3333333333");
      dentistRepository.save(dentist2);

      Surgery surgery2 = new Surgery();
      surgery2.setName("Smile Clinic");
      surgery2.setPhoneNumber("4444444444");

      Address saddr2 = new Address();
      saddr2.setLocation("101 Pine St");
      surgery2.setAddress(saddr2);
      surgeryRepository.save(surgery2);

      Appointment a2 = new Appointment();
      a2.setAppointmentDate(java.time.LocalDate.now().plusDays(1));
      a2.setAppointmentTime(java.time.LocalTime.of(10, 30));
      a2.setPatient(patient2);
      a2.setDentist(dentist2);
      a2.setSurgery(surgery2);
      appointmentRepository.save(a2);

      // ===================== RECORD 3 =====================
      Patient patient3 = new Patient();
      patient3.setFirstName("Robert");
      patient3.setEmail("robert@gmail.com");
      patient3.setLastName("White");
      patient3.setPhoneNumber("5556667777");

      Address addr3 = new Address();
      addr3.setLocation("222 Cedar St");
      patient3.setAddress(addr3);
      patientRepository.save(patient3);

      Dentist dentist3 = new Dentist();
      dentist3.setFirstName("Emma");
      dentist3.setLastName("Williams");
      dentist3.setPhoneNumber("6666666666");
      dentistRepository.save(dentist3);

      Surgery surgery3 = new Surgery();
      surgery3.setName("Healthy Teeth Clinic");
      surgery3.setPhoneNumber("7777777777");

      Address saddr3 = new Address();
      saddr3.setLocation("333 Maple St");
      surgery3.setAddress(saddr3);
      surgeryRepository.save(surgery3);

      Appointment a3 = new Appointment();
      a3.setAppointmentDate(java.time.LocalDate.now().plusDays(2));
      a3.setAppointmentTime(java.time.LocalTime.of(11, 0));
      a3.setPatient(patient3);
      a3.setDentist(dentist3);
      a3.setSurgery(surgery3);
      appointmentRepository.save(a3);

      // ===================== RECORD 4 =====================
      Patient patient4 = new Patient();
      patient4.setFirstName("David");
      patient4.setEmail("david@gmail.com");
      patient4.setLastName("Green");
      patient4.setPhoneNumber("8889990000");

      Address addr4 = new Address();
      addr4.setLocation("444 Birch St");
      patient4.setAddress(addr4);
      patientRepository.save(patient4);

      Dentist dentist4 = new Dentist();
      dentist4.setFirstName("Olivia");
      dentist4.setLastName("Taylor");
      dentist4.setPhoneNumber("9999999999");
      dentistRepository.save(dentist4);

      Surgery surgery4 = new Surgery();
      surgery4.setName("Bright Smile Center");
      surgery4.setPhoneNumber("1010101010");

      Address saddr4 = new Address();
      saddr4.setLocation("555 Walnut St");
      surgery4.setAddress(saddr4);
      surgeryRepository.save(surgery4);

      Appointment a4 = new Appointment();
      a4.setAppointmentDate(java.time.LocalDate.now().plusDays(3));
      a4.setAppointmentTime(java.time.LocalTime.of(9, 15));
      a4.setPatient(patient2);
      a4.setDentist(dentist3);
      a4.setSurgery(surgery4);
      appointmentRepository.save(a4);

      // ===================== RECORD 5 =====================
      Patient patient5 = new Patient();
      patient5.setFirstName("Sophia");
      patient5.setEmail("sophia@gmail.com");
      patient5.setLastName("Martinez");
      patient5.setPhoneNumber("1212121212");

      Address addr5 = new Address();
      addr5.setLocation("777 Spruce St");
      patient5.setAddress(addr5);
      patientRepository.save(patient5);

      Dentist dentist5 = new Dentist();
      dentist5.setFirstName("James");
      dentist5.setLastName("Anderson");
      dentist5.setPhoneNumber("1313131313");
      dentistRepository.save(dentist5);

      Surgery surgery5 = new Surgery();
      surgery5.setName("Elite Dental Clinic");
      surgery5.setPhoneNumber("1414141414");

      Address saddr5 = new Address();
      saddr5.setLocation("888 Chestnut St");
      surgery5.setAddress(saddr5);
      surgeryRepository.save(surgery5);

      Appointment a5 = new Appointment();
      a5.setAppointmentDate(java.time.LocalDate.now().plusDays(4));
      a5.setAppointmentTime(java.time.LocalTime.of(14, 45));
      a5.setPatient(patient3);
      a5.setDentist(dentist2);
      a5.setSurgery(surgery4);
      appointmentRepository.save(a5);
   }

   public void saveUserAndRole() {
       Role role = new Role();
       role.setRoleName("ADMIN");

       Role role2 = new Role();
       role2.setRoleName("USER");

      Role role3 = new Role();
      role3.setRoleName("MANAGER");

      roleRepository.saveAll(java.util.List.of(role, role2, role3));

      User user  = new User();
      user.setFirstName("Elen");
      user.setLastName("Smith");
      user.setUserName("elen");
      user.setPassword(passwordEncoder.encode("elen123"));
      user.setRoleList(Set.of(role, role2));

      User user2  = new User();
      user2.setFirstName("John");
      user2.setLastName("Smith");
      user2.setUserName("john");
      user2.setPassword(passwordEncoder.encode("john123"));
      user2.setRoleList(Set.of(role2, role3));

      User user3  = new User();
      user3.setFirstName("Usman");
      user3.setLastName("Nazera");
      user3.setUserName("usman");
      user3.setPassword(passwordEncoder.encode("usman123"));
      user3.setRoleList(Set.of(role2));

      User user4  = new User();
      user4.setFirstName("Alassane");
      user4.setLastName("Camara");
      user4.setUserName("alassane");
      user4.setPassword(passwordEncoder.encode("alassane123"));
      user4.setRoleList(Set.of(role2, role3));
      userRepository.saveAll(List.of(user, user2, user3, user4));
   }



}
