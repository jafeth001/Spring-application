package com.backend.demospringboot.Controller;

import com.backend.demospringboot.Entity.Student;
import com.backend.demospringboot.Error.StudentClassNotFoundException;
import com.backend.demospringboot.Service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(Studentcontroller.class)
class StudentcontrollerTest {
    @Autowired
    private MockMvc mockMvc;
    private Student student;
    @MockBean
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .id(1L)
                .name("Brian")
                .regno("IC21/21")
                .course("IT")
                .build();
    }

    @Test
    void saveStudent() throws Exception {
        Student inputstudent = Student.builder()
                .name("Brian")
                .regno("IC21/21")
                .course("IT")
                .build();
        Mockito.when(studentService.saveStudent(inputstudent)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/std")
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                                "    \"name\": \"Brian\",\n" +
                                "    \"regno\": \"IC21/21\",\n" +
                                "    \"course\": \"IT\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}