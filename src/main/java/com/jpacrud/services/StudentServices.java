package com.jpacrud.services;

import com.jpacrud.entities.Student;
import com.jpacrud.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//CRUD
@Service
public class StudentServices {
    @Autowired
    StudentRepository repository;

    //Create
    public Student saveStudent(Student student){
        return repository.save(student);
    }
    public List<Student> saveStudents(List<Student> students){
        return repository.saveAll(students);
    }

    //Read
    public Student findStudentById(int id){
        return repository.findById(id).orElse(null);
    }
    public List<Student> findStudentByFirstName(String firstname){
        return repository.findByFirstName(firstname);
    }
    public List<Student> findStudentByLastName(String lastname){
        return repository.findByLastName(lastname);
    }
    public List<Student> findStudentsBySection(String section){
        return repository.findBySection(section);
    }
    public Student findStudentByRollNumber(int rollnumber){
        return repository.findByRollNumber(rollnumber);
    }
    //Update
    public Student updateStudent(Student student){
        //locate data to update
        Student studentToUpdate = repository.findById(student.getStudentId()).orElse(null);
        //update with new values
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        studentToUpdate.setSection(student.getSection());
        studentToUpdate.setRollNumber(student.getRollNumber());
        //save: update
        return repository.save(studentToUpdate);    //there is no update method in JPA by default
    }

    //Delete
    public String deleteStudent(int id){
        repository.deleteById(id);
        return "Student with id:" + id + ", was deleted.";
    }

    //encrypt password with BCrypt: requires spring boot
    //spring boot by default secures all API endpoints
    //Application class:
    //@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

}
