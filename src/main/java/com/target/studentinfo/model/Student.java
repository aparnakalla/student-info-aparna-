package com.target.studentinfo.model;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "first_name")
    @NotNull
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String emailId;
    @Column(name = "blood_group")
    private String bloodGroup;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "standard")
    private int standard;
    @Column(name = "extracurricular")
    private String extraCurricular;
    @Column(name = "allergies")
    private String allergies;
    @Column(name = "transport")
    private String transport;
    @Column(name = "is_active")
    private boolean isActive = Boolean.TRUE;

}
