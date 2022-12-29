package com.example.mamnoncvn.report;

import com.example.mamnoncvn.student.entity.Student;
import com.example.mamnoncvn.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/client/report")
public class ReportController {

    //export to excel
    @Autowired
    StudentService studentService;
    @GetMapping("/excel1")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=student" + "123" + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Student> listOfStudents = studentService.getAll();
        ExcelGenerator generator = new ExcelGenerator(listOfStudents);
        generator.generateExcelFile(response);
    }

    @GetMapping("/excel2")
    public void testExcel() {
        List<Student> studentList = studentService.getAll();
        ExcelGenerator.tutorialsToExcel(studentList);
    }

}
