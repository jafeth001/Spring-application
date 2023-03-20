package com.backend.demospringboot.Service;

import com.backend.demospringboot.Entity.Student;
import com.backend.demospringboot.Error.StudentClassNotFoundException;
import com.backend.demospringboot.Repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    private StudentService studentService;
    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student student = Student.builder()
                .name("Jafeth")
                .id(1L)
                .course("IT")
                .regno("IC2021/21")
                .build();
        Mockito.when(studentRepository.findByNameIgnoreCase("Jafeth")).thenReturn(student);

    }

    @Test
    void getStudentByname() throws StudentClassNotFoundException {
        String name = "Jafeth";
        Student student = studentService.getStudentByname(name);
        assertEquals(name, student.getName());
    }
}