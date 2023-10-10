package com.target.studentinfo.service;
import com.target.studentinfo.exception.ErrorCode;
import com.target.studentinfo.exception.ErrorMessage;
import com.target.studentinfo.exception.NotFoundException;
import com.target.studentinfo.model.Student;
//import com.target.studentinfo.model.StudentValidator;
import com.target.studentinfo.respository.StudentRepository;
import jakarta.validation.Validation;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }
    public List<Student> getStudents(Boolean isActive, List<Integer> standardList){
        return studentRepository.getStudents(isActive,standardList);
    }

    public Optional<Student> getStudent(Boolean isActive, long id){
        return studentRepository.getStudent(isActive,id);
    }

    public Student addStudent(Student student){

        return studentRepository.save(student);
    }

    public Student updateStudent(Student student , long id) {
        student.setId(id);
        if (!studentRepository.existsById(id)) {
            throw new NotFoundException(ErrorCode.STUDENT_NOT_FOUND, ErrorMessage.STUDENT_NOT_FOUND);
        }

        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {studentRepository.deleteStudent(id);}
}





