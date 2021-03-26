package com.cs.studentapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService theStudentService){
        studentService = theStudentService;
    }

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable("studentId") Integer studentId){
        Student aStudent = studentService.findById(studentId);
        if (aStudent == null) {
            throw new RuntimeException("Student id not found " + studentId);
        }
        return aStudent;
    }

    @PostMapping
    public Student addEmployee(@RequestBody Student aStudent) {
        aStudent.setStudentId(0);
        return studentService.save(aStudent);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student aStudent) {
        return studentService.save(aStudent);
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {

        Student aStudent = studentService.findById(studentId);
        if (aStudent == null) {
            throw new RuntimeException("Student id " + studentId + " does not exist");
        }
        studentService.delete(studentId);
    }

}
