package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getStudentEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id "+studentId+
                    " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String studentName, String studentEmail) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException((
                        "Student with id "+studentId+"does not exist"
                        )));
        if (studentName != null && studentName.length() > 0 &&
                !Objects.equals(student.getStudentName(), studentName)) {
            student.setStudentName(studentName);
        }

        if (studentEmail != null && studentEmail.length() > 0 &&
                !Objects.equals(student.getStudentEmail(), studentEmail)) {
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(studentEmail);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email has taken");
            }
            student.setStudentEmail(studentEmail);
        }
    }
}
