package com.example.mamnoncvn.student.service;

import com.example.mamnoncvn.ClassManager.service.CVN_ClassService;
import com.example.mamnoncvn.exception.NotFoundException;
import com.example.mamnoncvn.student.entity.Student;
import com.example.mamnoncvn.student.models.mapper.StudentMapper;
import com.example.mamnoncvn.student.models.request.CreateStudentRequest;
import com.example.mamnoncvn.student.models.request.UpdateStudentRequest;
import com.example.mamnoncvn.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CVN_ClassService classService;

    public List<Student> getAll() {
            return studentRepository.findAll();
    }
    public void insertNewStudent(CreateStudentRequest createStudentRequest) {
        Student newStudent = new Student();
        newStudent = StudentMapper.CreateStudentRequestToEntity(newStudent ,createStudentRequest);
        newStudent.setCvn_class(classService.findClassByID(Long.parseLong(createStudentRequest.getMaLop())));
        studentRepository.save(newStudent);
    }

    public void deleteStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else throw new NotFoundException("Student id not found");
    }
    public Student updateStudent(UpdateStudentRequest updateStudentRequest){
        Student oldStudent = studentRepository.findById(updateStudentRequest.getId()).get();
        oldStudent = StudentMapper.convertUpdateStudentRequestToEntity(oldStudent, updateStudentRequest);

        studentRepository.saveAndFlush(oldStudent);

        return oldStudent;
    }

    public List<Student> findAllByKeyword(String keyword) {
        if (keyword != null) {
            return studentRepository.findAllByKeyword(keyword);
        } else return studentRepository.findAll();
    }
}
