package com.target.studentinfo.dto.request;

import com.target.studentinfo.model.AllValidationErrorsGroup;
import com.target.studentinfo.model.Gender;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
//import org.antlr.v4.runtime.misc.NotNull;
//import javax.validation.GroupSequence;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
//@GroupSequence({Default.class, AllValidationErrorsGroup.class})
public class StudentRequest implements Serializable {

    @NotNull(message = "First name cannot be null",groups = AllValidationErrorsGroup.class)
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters",groups = AllValidationErrorsGroup.class)
    private String firstName;
    @NotNull(message = "First name cannot be null",groups = AllValidationErrorsGroup.class)
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters",groups = AllValidationErrorsGroup.class)
    private String lastName;
    @Pattern(regexp = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,4}$", message = "Invalid email format", groups = AllValidationErrorsGroup.class)
    private String emailId;
    @Pattern(regexp = "^(A|B|AB|O)[+-]$",flags = Pattern.Flag.CASE_INSENSITIVE,message = "Invalid Blood Group", groups = AllValidationErrorsGroup.class)
    private String bloodGroup;
    private String fatherName;
    private String motherName;
    @Min(value = 2, message = "Age must be at least 2",groups = AllValidationErrorsGroup.class)
    @Max(value = 100, message = "Age must be at most 100",groups = AllValidationErrorsGroup.class)
    private int age;
//    @NotNull(message = "Gender cannot be null",groups = AllValidationErrorsGroup.class)
//    @Pattern(regexp = "^(male|female|prefer not to say)$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid gender",groups = AllValidationErrorsGroup.class)
//    private String gender;

    @NotNull(message = "Gender cannot be null", groups = {AllValidationErrorsGroup.class})
    @GenderEnum(groups = {AllValidationErrorsGroup.class}) // Use EnumType.STRING to store the enum values as strings in the database
    private String gender;
    @NotNull(message = "address cannot be null",groups = AllValidationErrorsGroup.class)
    private String address;
    @Min(value = 1, message = "Standard must be at least 1",groups = AllValidationErrorsGroup.class)
    @Max(value = 12, message = "Standard must be at most 12",groups = AllValidationErrorsGroup.class)
    private int standard;
    @NotNull(message = "extraCurricular cannot be null",groups = AllValidationErrorsGroup.class)
    private String extraCurricular;
    private String allergies;
    @NotNull(message = "transport cannot be null",groups = AllValidationErrorsGroup.class)
    private String transport;
    private boolean isActive = Boolean.TRUE;


}
