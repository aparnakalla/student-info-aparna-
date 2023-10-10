package com.target.studentinfo;
import com.target.studentinfo.dto.request.StudentRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class StudentRequestTests {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testValidStudentRequest() {
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setFirstName("John");
        studentRequest.setLastName("Doe");
        studentRequest.setEmailId("john@example.com");
        studentRequest.setBloodGroup("A+");
        studentRequest.setAge(18);
        studentRequest.setGender("male");
        studentRequest.setAddress("123 Main St");
        studentRequest.setStandard(10);
        studentRequest.setExtraCurricular("Sports");
        studentRequest.setTransport("Bus");

        Set<ConstraintViolation<StudentRequest>> violations = validator.validate(studentRequest);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testInvalidFirstName() {
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setFirstName(""); // Empty first name

        Set<ConstraintViolation<StudentRequest>> violations = validator.validate(studentRequest);
        assertFalse(violations.isEmpty());
        assertEquals("First name cannot be null", violations.iterator().next().getMessage());
    }

    @Test
    void testInvalidGender() {
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setGender("unknown"); // Invalid gender

        Set<ConstraintViolation<StudentRequest>> violations = validator.validate(studentRequest);
        assertFalse(violations.isEmpty());
        assertEquals("Invalid gender", violations.iterator().next().getMessage());
    }

    // Add more test cases for other validation scenarios (e.g., last name, email, age, etc.)
}
