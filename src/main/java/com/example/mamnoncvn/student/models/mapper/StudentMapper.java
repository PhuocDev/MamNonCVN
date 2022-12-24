package com.example.mamnoncvn.student.models.mapper;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.ClassManager.service.CVN_ClassService;
import com.example.mamnoncvn.student.entity.Student;
import com.example.mamnoncvn.student.models.request.CreateStudentRequest;
import com.example.mamnoncvn.student.models.request.UpdateStudentRequest;
import com.example.mamnoncvn.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentMapper {


    public static Student CreateStudentRequestToEntity(Student student, CreateStudentRequest createStudentRequest) {
        student.setTenHocSinh(createStudentRequest.getTenHocSinh());
        student.setNgaySinh(createStudentRequest.getNgaySinh());
        student.setGioiTinh(createStudentRequest.getGioiTinh());
        student.setChieuCao(createStudentRequest.getChieuCao());
        student.setCanNang(createStudentRequest.getCanNang());
        student.setTenPhuHuynh(createStudentRequest.getTenPhuHuynh());
        student.setSoDienThoai(createStudentRequest.getSoDienThoai());
        student.setEmail(createStudentRequest.getEmail());
        student.setNgayNhapHoc(createStudentRequest.getNgayNhapHoc());
        student.setGhiChu(createStudentRequest.getGhiChu());
        student.setStatus(createStudentRequest.getStatus());
        student.setDiaChi(createStudentRequest.getDiaChi());
        return student;
    }

    public static Student convertUpdateStudentRequestToEntity(Student student ,UpdateStudentRequest updateStudentRequest) {

        student.setTenHocSinh(updateStudentRequest.getTenHocSinh());
        student.setNgaySinh(updateStudentRequest.getNgaySinh());
        student.setGioiTinh(updateStudentRequest.getGioiTinh());
        student.setChieuCao(updateStudentRequest.getChieuCao());
        student.setCanNang(updateStudentRequest.getCanNang());
        student.setTenPhuHuynh(updateStudentRequest.getTenPhuHuynh());
        student.setSoDienThoai(updateStudentRequest.getSoDienThoai());
        student.setEmail(updateStudentRequest.getEmail());
        student.setNgayNhapHoc(updateStudentRequest.getNgayNhapHoc());
        student.setGhiChu(updateStudentRequest.getGhiChu());
        student.setStatus(updateStudentRequest.getStatus());
        student.setDiaChi(updateStudentRequest.getDiaChi());
        return student;
    }
}
