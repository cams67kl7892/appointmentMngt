package lab6.cs489.appointmentMngt;


import lab6.cs489.appointmentMngt.controller.PatientController;
import lab6.cs489.appointmentMngt.dto.PatientDto;
import lab6.cs489.appointmentMngt.model.Patient;
import lab6.cs489.appointmentMngt.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//import java.util.List;
//
//@WebMvcTest(PatientController.class)
//class PatientControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private PatientService patientService;
//
//    @Test
//    void testGetAllPatients() throws Exception {
//
//        List<PatientDto> patients = List.of(
//                new Patient(1L, "Alice"),
//                new Patient(2L, "Bob")
//        );
//
//        Mockito.when(patientService.getPatients())
//                .thenReturn(patients);
//
//        mockMvc.perform(get("/patients"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()").value(2))
//                .andExpect(jsonPath("$[0].name").value("Alice"))
//                .andExpect(jsonPath("$[1].name").value("Bob"));
//    }
//}
