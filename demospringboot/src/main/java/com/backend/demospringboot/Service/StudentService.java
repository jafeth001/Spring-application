package com.backend.demospringboot.Service;

import com.backend.demospringboot.Entity.Student;
import com.backend.demospringboot.Error.StudentClassNotFoundException;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    public List<Student> getstudentList() throws StudentClassNotFoundException;

    public Student getStudentbyId(Long id) throws StudentClassNotFoundException;

    public Student getStudentByname(String name) throws StudentClassNotFoundException;

    public void deletestudentbyid(Long id);

    public void updatesstudentbyid(Long id, Student student);

    ;
}
