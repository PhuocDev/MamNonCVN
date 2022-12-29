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
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/client/report")
public class ReportController {

    //export to excel
    @Autowired
    ExcelService fileService;

    @GetMapping("/student-download")
    public ResponseEntity<Resource> getStudentFile() {
        int nameInsert =  (int)(Math.random()*(99999-10000+1)+10000);
        String filename = "studentReport" + nameInsert + ".xlsx";
        InputStreamResource file = new InputStreamResource(fileService.load_exportStudentExcel());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
    @GetMapping("/class-download")
    public ResponseEntity<Resource> getClassFileReport() {
        int nameInsert =  (int)(Math.random()*(99999-10000+1)+10000);
        String filename = "classReport" + nameInsert + ".xlsx";
        InputStreamResource file = new InputStreamResource(fileService.load_exportClassExcel());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    @GetMapping("/teacher-download")
    public ResponseEntity<Resource> getTeacherFileReport() {
        int nameInsert =  (int)(Math.random()*(99999-10000+1)+10000);
        String filename = "teacherReport" + nameInsert + ".xlsx";
        InputStreamResource file = new InputStreamResource(fileService.load_exportTeachersExcel());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    @GetMapping("/cth-download")
    public ResponseEntity<Resource> getCTHFileReport() {
        int nameInsert =  (int)(Math.random()*(99999-10000+1)+10000);
        String filename = "cthReport" + nameInsert + ".xlsx";
        InputStreamResource file = new InputStreamResource(fileService.load_exportCTHExcel());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
}
