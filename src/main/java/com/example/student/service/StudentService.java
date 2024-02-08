package com.example.student.service;

import com.example.student.model.StudentModel;
import com.example.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public void saveStudent(StudentModel student){
    studentRepository.save(student);
}

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> getStudentList(){
        return studentRepository.findAll();
    }
    public StudentModel getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public void saveEditStudent(StudentModel student, Long id){
        student.setId(id);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
