package com.student_data.student.project.controller;

import com.student_data.student.project.exception.StudentNotFoundException;
import com.student_data.student.project.model.Student;
import com.student_data.student.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
//        System.out.println("This is student name "+ student.getName());
//        System.out.println("This is student age "+ student.getAge());
        studentService.addStudent(student);
        System.out.println(student.toString());
        return "Student added sucessfully";
    }
    @GetMapping("/delete")
    public  ResponseEntity<String>  deleteByRollNo(@RequestParam int rollNo) {
        try {
            Student s = studentService.deleteStudentByRollNo(rollNo);
            return ResponseEntity.ok("Student with rollNo " + rollNo + " deleted successfully.");
        } catch (StudentNotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping("/updateAge")
    public ResponseEntity<String> updateAge(@RequestParam int rollNo, @RequestParam int age){
        try {
            studentService.updateStudentAge(rollNo,age);
            return ResponseEntity.ok("Age of student " +rollNo+ " is updated to "+age);
        } catch (StudentNotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/getAboveAge")
    public List<Student> getStudentAboveAge(){
        return studentService.getStudentAboveAge25();
    }

    @DeleteMapping("/deleteAllStudents")
    public String deleteStudents(){
        studentService.deleteAllStudents();
        return "All Student's data deleted succesfully";
    }
}
