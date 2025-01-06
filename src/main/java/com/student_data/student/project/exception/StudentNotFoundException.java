package com.student_data.student.project.exception;

public class StudentNotFoundException extends RuntimeException{
    public  StudentNotFoundException(String mssg){
        super(mssg);
    }
}
