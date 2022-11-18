package com.example.mamnoncvn.ClassManager.controller;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.ClassManager.models.request.CreateClassRequest;
import com.example.mamnoncvn.ClassManager.service.CVN_ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/class")
public class CVN_ClassController {
    @Autowired
    CVN_ClassService classService;


    @GetMapping
    public List<CVN_Class> index() {
        return classService.getAll();
    }
    @GetMapping("/createDB")
    public List<CVN_Class> createDB() {
        for (int i = 1; i < 5; i++) {
            CreateClassRequest newClass = new CreateClassRequest("Lop A" + i, i + 1, LocalDate.now(), LocalDate.now(), (long) (i*1500000), i*5, "Giao vien "+ i,
                    "giao vien " + i+10, true);
            classService.save(newClass);
        }

        return classService.getAll();
    }


}
