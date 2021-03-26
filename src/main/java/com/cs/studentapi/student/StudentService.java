package com.cs.studentapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Student findById(Integer studentId) {
        Optional<Student> result = studentRepository.findById(studentId);

        Student aStudent = null;

        if (result.isPresent()) {
            aStudent = result.get();
        } else {
            throw new RuntimeException("Did not find student id - " + studentId);
        }
        return aStudent;
    }

    public Student save(Student aStudent) {
        return studentRepository.save(aStudent);
    }

    public void delete(int studentId) {
        studentRepository.deleteById(studentId);
    }

}
