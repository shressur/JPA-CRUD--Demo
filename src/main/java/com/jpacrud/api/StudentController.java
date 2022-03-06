package com.jpacrud.api;

import com.jpacrud.entities.Student;
import com.jpacrud.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")         //base_url/api/end_point
public class StudentController {
    @Autowired
    StudentServices studentServices;
    //GET
    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable int id){
        return studentServices.findStudentById(id);
    }
    //same path with different query parameter
    @GetMapping(value = "/student", params = "fName")
    public List<Student> findStudentByFirstName(@RequestParam ("fName") String firstName){
        return studentServices.findStudentByFirstName(firstName);
    }
    @GetMapping(value = "/student", params = "lName")
    public List<Student> findStudentByLastName(@RequestParam ("lName") String lastName){
        return studentServices.findStudentByLastName(lastName);
    }
    @GetMapping(value = "/student", params = "section")
    public List<Student> findStudentsByRollNumber(@RequestParam ("section") String section){
        return studentServices.findStudentsBySection(section);
    }

    @GetMapping(value = "/student", params = "rNum")
    public Student findStudentByRollNumber(@RequestParam ("rNum") int rollNumber){
        return studentServices.findStudentByRollNumber(rollNumber);
    }
//    @GetMapping(value = "/student", params = {"fName", "lName", "section"}) //all of these return a list
//    public List<Student> findByQueryParam(@RequestParam String fName,
//                                              @RequestParam String lName,
//                                              @RequestParam String section){
//        if(fName != null){
//            //primitive data types are not nullable i.e. "int i" cannot be "== null" rather check "== 0" (if not initialized then it is 0)
//            //char is not nullable char=='\0' meaning having no value but char="" meaning having a space
//            return studentServices.findStudentByFirstName(fName);
//        } else if(lName != null && fName==null && section==null){
//            return studentServices.findStudentByLastName(lName);
//        } else if(section !=null && fName == null && lName==null){
//            return studentServices.findStudentsBySection(section);
//        } else {
//            return null;
//        }
//    }

    //POST
    @PostMapping("/student/new")
    public Student saveStudent(@RequestBody Student student){
        return studentServices.saveStudent(student);
    }
    //save multiple students
    @PostMapping("/student/new-multi")
    public List<Student> saveStudent(@RequestBody List<Student> students){
        return studentServices.saveStudents(students);
    }

    //PUT
    @PostMapping("/student/update")
    public Student updateStudent(@RequestBody Student student){
        return studentServices.updateStudent(student);
    }

    //DELETE
    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentServices.deleteStudent(id);
    }
}
