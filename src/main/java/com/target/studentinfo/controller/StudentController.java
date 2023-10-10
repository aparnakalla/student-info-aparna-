package com.target.studentinfo.controller;
import com.target.studentinfo.dto.mapper.StudentMapper;
import com.target.studentinfo.dto.request.StudentRequest;
import com.target.studentinfo.dto.response.StudentResponse;
import com.target.studentinfo.model.AllValidationErrorsGroup;
import com.target.studentinfo.model.Student;
import com.target.studentinfo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;

//import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Validated
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService , StudentMapper studentMapper  ) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping("/students/all")
    public List<StudentResponse> getAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        return studentMapper.toStudentResponseList(allStudents);
    }

    @GetMapping("/students")
    public List<StudentResponse> getStudents(@RequestParam(defaultValue="true") Boolean isActive, @RequestParam List<Integer> standardList){
        List<Student> students = studentService.getStudents(isActive, standardList);
        return studentMapper.toStudentResponseList(students);
    }

    @GetMapping("/students/{id}")
    public StudentResponse getStudent(@RequestParam(defaultValue="true") Boolean isActive, @PathVariable("id") long id){
        Optional<Student> student = studentService.getStudent(isActive, id);
        return studentMapper.toStudentResponse(student);
    }

    @PostMapping("/students")
    public ResponseEntity<Object> addStudent(@Validated(AllValidationErrorsGroup.class) @RequestBody StudentRequest studentRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errorMessages);
        }

        // If there are no validation errors, proceed to add the student
        Student student = studentMapper.toStudent(studentRequest);
        Student addedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(studentMapper.toStudentResponse(addedStudent));
    }
//    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentRequest studentRequest, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//
//            // Handle validation errors and return an appropriate response
//            List<String> errorMessages = bindingResult.getAllErrors()
//                    .stream()
//                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                    .collect(Collectors.toList());
//
//            return ResponseEntity.badRequest().body(errorMessages);
//        }
//
//        // If there are no validation errors, proceed to add the student
//        Student student = studentMapper.toStudent(studentRequest);
//        Student addedStudent = studentService.addStudent(student);
//        return ResponseEntity.ok(studentMapper.toStudentResponse(addedStudent));
//    }
//    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest){
//        Student student = studentMapper.toStudent(studentRequest);
//        Student addedStudent = studentService.addStudent(student);
//        return studentMapper.toStudentResponse(addedStudent);
//    }

    @PutMapping("/students/{id}")
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest, @PathVariable("id") long id) {
        Student student = studentMapper.toStudent(studentRequest);
        Student updatedStudent = studentService.updateStudent(student,id);
        return studentMapper.toStudentResponse(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
    }
}
