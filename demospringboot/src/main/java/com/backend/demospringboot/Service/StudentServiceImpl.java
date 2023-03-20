package com.backend.demospringboot.Service;

import com.backend.demospringboot.Entity.Student;
import com.backend.demospringboot.Error.StudentClassNotFoundException;
import com.backend.demospringboot.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getstudentList() throws StudentClassNotFoundException {
        List<Student>  std = studentRepository.findAll();
        if(!std.isEmpty()){
            return std;
        }
        throw new StudentClassNotFoundException("Ooops!!! Students are not found");
    }

    @Override
    public Student getStudentbyId(Long id) throws StudentClassNotFoundException {
        Optional<Student> std =  studentRepository.findById(id);
        if(std.isPresent()){
            return std.get();
        }
        throw new StudentClassNotFoundException("Ooops!!! Selected student is not found");
    }

    @Override
    public Student getStudentByname(String name) throws StudentClassNotFoundException {
        Student std = studentRepository.findByNameIgnoreCase(name);
        if(std==null){
            throw new StudentClassNotFoundException("Ooops!!! Selected student is not found");
        }
        return std;
    }

    @Override
    public void deletestudentbyid(Long id) {
         studentRepository.deleteById(id);
    }

    @Override
    public void updatesstudentbyid(Long id, Student student) {
       Student  std = studentRepository.findById(id).get();
       if(Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())){
           std.setName(student.getName());
       }
        if(Objects.nonNull(student.getRegno()) && !"".equalsIgnoreCase(student.getRegno())){
            std.setRegno(student.getRegno());
        }
        if(Objects.nonNull(student.getCourse()) && !"".equalsIgnoreCase(student.getCourse())){
            std.setCourse(student.getCourse());
        }
        studentRepository.save(std);
    }


}
