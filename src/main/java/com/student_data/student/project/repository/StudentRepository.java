package com.student_data.student.project.repository;

import com.student_data.student.project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
   Student findByRollNo(int rollNo);
}
