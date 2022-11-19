package com.example.mamnoncvn.ClassManager.controller;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.ClassManager.models.mapper.CVN_ClassMapper;
import com.example.mamnoncvn.ClassManager.models.request.CreateClassRequest;
import com.example.mamnoncvn.ClassManager.models.request.UpdateClassRequest;
import com.example.mamnoncvn.ClassManager.service.CVN_ClassService;
import com.example.mamnoncvn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/class")
public class CVN_ClassController {
    @Autowired
    CVN_ClassService classService;

    @GetMapping("/")
    public String index(Model model){
        List<CVN_Class> cvn_classes = classService.getAll();
        model.addAttribute("classes", cvn_classes);
        CreateClassRequest createClassRequest = new CreateClassRequest();
        model.addAttribute("createClassRequest", createClassRequest);

        UpdateClassRequest updateClassRequest = new UpdateClassRequest();
        model.addAttribute("updateClassRequest", updateClassRequest);
        return "/admin/class";
    }

    @PostMapping(path = "/add",  consumes = "application/x-www-form-urlencoded")
    public String addNewClass(Model model,@Valid @ModelAttribute("createClassRequest") CreateClassRequest createClassRequest) {
        classService.save(createClassRequest);
        return "redirect:/class/";
    }
    @PostMapping(path = "/update",  consumes = "application/x-www-form-urlencoded")
    public String updateClass(Model model,@Valid @ModelAttribute("updateClassRequest") UpdateClassRequest updateClassRequest) {
        classService.updateClass(updateClassRequest);
        return "redirect:/class/";
    }
    @GetMapping("/deleteClass")
    public String deleteClass(@PathParam("id") Long id, Model model){
        classService.deleteClassById(id);
        return "redirect:/blog/all";
    }

    @GetMapping("/createDB")
    public List<CVN_Class> createDB() {
        for (int i = 1; i < 5; i++) {
            CreateClassRequest newClass = new CreateClassRequest("Lop A" + i, i + 1, LocalDate.now(), LocalDate.now(), (long) (i*1500000), i*5, "Giao vien "+ i,
                    "giao vien " + i+10, false);
            classService.save(newClass);
        }

        return classService.getAll();
    }


}
