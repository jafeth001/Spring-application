package com.backend.demospringboot.Controller;

import com.backend.demospringboot.Entity.Student;
import com.backend.demospringboot.Error.StudentClassNotFoundException;
import com.backend.demospringboot.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Studentcontroller {
    @Autowired
    private StudentService studentService;
    private final Logger log = LoggerFactory.getLogger(Studentcontroller.class);

    @PostMapping("/std")
    public Student saveStudent(@RequestBody Student student) throws StudentClassNotFoundException {
        log.info("==== inside save Student ====");
        return studentService.saveStudent(student);
    }

    @GetMapping("/std")
    public List<Student> getstudentList() throws StudentClassNotFoundException {
        log.info("==== inside get Student list ====");
        return studentService.getstudentList();
    }

    @GetMapping("/std/{id}")
    public Student getStudentbyId(@PathVariable("id") Long id) throws StudentClassNotFoundException {
        log.info("==== inside get St  udent by id ====");
        return studentService.getStudentbyId(id);
    }

    @GetMapping("/std/name/{name}")
    public Student getStudentByname(@PathVariable("name") String name) throws StudentClassNotFoundException {
        log.info("==== inside get Student by name ====");
        return studentService.getStudentByname(name);
    }

    @DeleteMapping("/std/{id}")
    public String deletestudentbyid(@PathVariable("id") Long id) {
        log.info("==== inside delete Student by id ====");
        studentService.deletestudentbyid(id);
        return "Student selected Successfully deleted";
    }
    @PutMapping("/std/{id}")
    public String updatesstudentbyid(@PathVariable("id") Long id ,@RequestBody Student student) {
        log.info("==== inside updated Student by id ====");
        studentService.updatesstudentbyid(id,student);
        return "Student selected Successfully updated";
    }
    }
