package com.golfplot.api.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(value = "/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId) {
        Integer parsedId = Integer.parseInt(studentId);
        System.out.println("Hello");
        Student gotStudent = studentRepository.findById(parsedId).orElseThrow();
        return new ResponseEntity<>(gotStudent, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
}
