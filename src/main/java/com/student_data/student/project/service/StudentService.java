package com.student_data.student.project.service;

import com.student_data.student.project.exception.StudentNotFoundException;
import com.student_data.student.project.model.Student;
import com.student_data.student.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public Student deleteStudentByRollNo(int rollNo) {
        Student student = studentRepository.findByRollNo(rollNo);
        if(student==null){
            throw new StudentNotFoundException("Student with rollNo. "+ rollNo + " not found");
        }
            studentRepository.delete(student);
        return student;
    }

}
