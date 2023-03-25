package com.backend.demospringboot.Repository;

import com.backend.demospringboot.Entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TestEntityManager testEntityManager;
    @BeforeEach
    void setUp() {
        Student student = Student.builder()
                .name("Jafeth")
                .course("IT")
                .regno("IC2021/21")
                .build();
        testEntityManager.persist(student);
    }
    @Test
    public void whenidvalidreturnstudent(){
        Student student = studentRepository.findById(1L).get();
        assertEquals(student.getName(),"Jafeth");
    }
}
