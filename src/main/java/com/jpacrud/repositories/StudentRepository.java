package com.jpacrud.repositories;

import com.jpacrud.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//exposes JPA methods
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByFirstName(String firstname);
    List<Student> findByLastName(String lastname);
    List<Student> findBySection(String section);
    Student findByRollNumber(int rollNumber);

}
