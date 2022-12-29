package com.example.mamnoncvn.report;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.ClassManager.service.CVN_ClassService;
import com.example.mamnoncvn.GiaoVienCVN.entity.GiaoVien;
import com.example.mamnoncvn.GiaoVienCVN.service.GiaoVienService;
import com.example.mamnoncvn.chuongTrinhHoc.entity.ChuongTrinhHoc;
import com.example.mamnoncvn.chuongTrinhHoc.service.ChuongTrinhHocService;
import com.example.mamnoncvn.student.entity.Student;
import com.example.mamnoncvn.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    StudentService studentService;
    @Autowired
    CVN_ClassService classService;
    @Autowired
    GiaoVienService giaoVienService;


    public ByteArrayInputStream load_exportStudentExcel() {
        List<Student> studentList = studentService.getAll();
        ByteArrayInputStream in = ExcelHelper.studentsToExcel(studentList);
        return in;
    }
    public ByteArrayInputStream load_exportClassExcel() {
        List<CVN_Class> cvn_classes = classService.getAll();
        ByteArrayInputStream in = ExcelHelper.classToExcel(cvn_classes);
        return in;
    }

    public ByteArrayInputStream load_exportTeachersExcel() {
        List<GiaoVien> giaoVienList = giaoVienService.getAllGV();
        ByteArrayInputStream in = ExcelHelper.teacherToExcel(giaoVienList);
        return in;
    }

    @Autowired
    ChuongTrinhHocService chuongTrinhHocService;

    public ByteArrayInputStream load_exportCTHExcel() {
        List<ChuongTrinhHoc> chuongTrinhHocList = chuongTrinhHocService.getAll();
        ByteArrayInputStream in = ExcelHelper.CTHToExcel(chuongTrinhHocList);
        return in;
    }
}
