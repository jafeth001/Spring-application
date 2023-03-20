package com.backend.demospringboot.Repository;

import com.backend.demospringboot.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public Student findByName(String name);
    public Student findByNameIgnoreCase(String name);


}
