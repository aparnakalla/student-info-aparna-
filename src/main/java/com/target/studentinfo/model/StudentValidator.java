//package com.target.studentinfo.model;
//
//import com.target.studentinfo.exception.BadRequestException;
//import com.target.studentinfo.exception.ErrorCode;
//import com.target.studentinfo.exception.ErrorMessage;
//import com.target.studentinfo.model.Student;
//
//public class StudentValidator {
//    public static void validateStudent(Student student) {
//        if (student == null) {
//            throw new BadRequestException(ErrorCode.INVALID_REQUEST_BODY, ErrorMessage.INVALID_REQUEST_BODY);
//        }
//
//        if (student.getFirstName() == null) {
//            throw new BadRequestException(ErrorCode.INVALID_FIRST_NAME, ErrorMessage.INVALID_FIRST_NAME);
//        }
//
//        if (student.getLastName() == null) {
//            throw new BadRequestException(ErrorCode.INVALID_LAST_NAME, ErrorMessage.INVALID_LAST_NAME);
//        }
//
//        if (student.getStandard() < 1 || student.getStandard() > 10) {
//            throw new BadRequestException(ErrorCode.INVALID_STANDARD, ErrorMessage.INVALID_STANDARD);
//        }
//    }
//}
