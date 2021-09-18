package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private LocalDate studentDateOfBirth;
    private Integer studentAge;

    public Student() {
    }

    public Student(Long studentId, String studentName,
                   String studentEmail, LocalDate studentDateOfBirth,
                   Integer studentAge) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentAge = studentAge;
    }

    public Student(String studentName, String studentEmail,
                   LocalDate studentDateOfBirth, Integer studentAge) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentAge = studentAge;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public LocalDate getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(LocalDate studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentDateOfBirth=" + studentDateOfBirth +
                ", studentAge=" + studentAge +
                '}';
    }
}
