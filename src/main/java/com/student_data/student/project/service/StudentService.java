package com.student_data.student.project.service;

import com.student_data.student.project.exception.StudentNotFoundException;
import com.student_data.student.project.model.Student;
import com.student_data.student.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void updateStudentAge(int rollNo, int age) {
        Student student = studentRepository.findByRollNo(rollNo);
        if(student==null){
            throw new StudentNotFoundException("Student with rollNo. "+ rollNo + " not found");
        }
        student.setAge(age);

        studentRepository.save(student);
    }

    public List<Student> getStudentAboveAge25() {
        List<Student>list=studentRepository.findAll();
        List<Student> listAbove25 = new ArrayList<>();
        for(Student s:list){
            if(s.getAge()>=25){
                listAbove25.add(s);
            }
        }
        return listAbove25;
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
