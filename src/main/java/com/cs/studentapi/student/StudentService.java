package com.cs.studentapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository theStudentRepository){
        studentRepository = theStudentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

}
