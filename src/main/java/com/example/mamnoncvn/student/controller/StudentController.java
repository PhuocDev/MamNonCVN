package com.example.mamnoncvn.student.controller;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.ClassManager.service.CVN_ClassService;
import com.example.mamnoncvn.chuongTrinhHoc.models.request.CreateChuongTrinhHocRequest;
import com.example.mamnoncvn.chuongTrinhHoc.models.request.UpdateChuongTrinhHocRequest;
import com.example.mamnoncvn.student.entity.Student;
import com.example.mamnoncvn.student.models.request.CreateStudentRequest;
import com.example.mamnoncvn.student.models.request.UpdateStudentRequest;
import com.example.mamnoncvn.student.repository.StudentRepository;
import com.example.mamnoncvn.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    CVN_ClassService classService;

    @GetMapping("/createDB")
    public List<Student> createDB() {
        for (int i = 1; i < 5; i++) {
            CreateStudentRequest createStudentRequest = new CreateStudentRequest(
                    "Ten hoc sinh " + i,
                    LocalDate.now().minusYears(i),
                    "nam",
                    80,
                    30,
                    "Ten phu huynh "+ i,
                    "0987654321",
                    "email"+i+"@gmail.com",
                    "Dia chi " + i,
                    LocalDate.now().minusMonths(i),
                    "ghi chu tam thoi",
                    "52",
                    true
            );
            System.out.println(createStudentRequest.toString());
            studentService.insertNewStudent(createStudentRequest);
        }
        return studentService.getAll();
    }
    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String keyword,@RequestParam(required = false) String category ) {
        List<Student> studentList = studentService.getAll();
        if (keyword != null && "all".equals(category)) {
            studentList = studentService.findAllByKeyword(keyword);
        }
        if(keyword != null && !"all".equals(category)) {
            studentList = studentService.findAllByCategory(keyword,category);
        }
        model.addAttribute("studentList", studentList);

        CreateStudentRequest createStudentRequest = new CreateStudentRequest();
        model.addAttribute("createStudentRequest", createStudentRequest);

        UpdateStudentRequest updateStudentRequest = new UpdateStudentRequest();
        model.addAttribute("updateStudentRequest", updateStudentRequest);

        //searching function
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        String categoryKeyword = null;
        model.addAttribute("category", categoryKeyword);

        //class id insert
        List<CVN_Class> danhSachLop = classService.findAllWorkingClass();
        model.addAttribute("danhSachLop", danhSachLop);

        return "admin/student";
    }
    @PostMapping(path = "/add",  consumes = "application/x-www-form-urlencoded")
    public String addNewStudent(Model model,@Valid @ModelAttribute("createStudentRequest") CreateStudentRequest createStudentRequest) {
        studentService.insertNewStudent(createStudentRequest);
        return "redirect:/student/";
    }
    @PostMapping(path = "/update",  consumes = "application/x-www-form-urlencoded")
    public String updateStudent(Model model,@Valid @ModelAttribute("updateStudentRequest") UpdateStudentRequest updateStudentRequest) {
        studentService.updateStudent(updateStudentRequest);
        return "redirect:/student/";
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@PathParam("id") Long id, Model model){
        studentService.deleteStudentById(id);
        return "redirect:/student/";
    }

}
