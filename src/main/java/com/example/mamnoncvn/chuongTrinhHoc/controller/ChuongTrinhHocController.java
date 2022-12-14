package com.example.mamnoncvn.chuongTrinhHoc.controller;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.ClassManager.service.CVN_ClassService;
import com.example.mamnoncvn.chuongTrinhHoc.entity.ChuongTrinhHoc;
import com.example.mamnoncvn.chuongTrinhHoc.models.request.CreateChuongTrinhHocRequest;
import com.example.mamnoncvn.chuongTrinhHoc.models.request.UpdateChuongTrinhHocRequest;
import com.example.mamnoncvn.chuongTrinhHoc.service.ChuongTrinhHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin/cth")
public class ChuongTrinhHocController {
    @Autowired
    ChuongTrinhHocService chuongTrinhHocService;
    @Autowired
    CVN_ClassService classService;

    @GetMapping(path = "/")
    public String index(Model model, @RequestParam(required = false) String keyword) {
        List<ChuongTrinhHoc> chuongTrinhHocList = chuongTrinhHocService.getAll();
        if (keyword != null) {
            chuongTrinhHocList = chuongTrinhHocService.findAllByKeyword(keyword);
        }

        model.addAttribute("danhSachCTH", chuongTrinhHocList);
        CreateChuongTrinhHocRequest createChuongTrinhHocRequest = new CreateChuongTrinhHocRequest();
        model.addAttribute("createChuongTrinhHocRequest", createChuongTrinhHocRequest);

        UpdateChuongTrinhHocRequest updateChuongTrinhHocRequest = new UpdateChuongTrinhHocRequest();
        model.addAttribute("updateChuongTrinhHocRequest", updateChuongTrinhHocRequest);

        //searching function
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);

        //class id insert
        List<CVN_Class> danhSachLop = classService.findAllWorkingClass();
        model.addAttribute("danhSachLop", danhSachLop);

        return "/admin/chuongtrinhhoc";
    }

    @PostMapping(path = "/add",  consumes = "application/x-www-form-urlencoded")
    public String addNewChuongTrinhHoc(Model model,@Valid @ModelAttribute("createChuongTrinhHocRequest") CreateChuongTrinhHocRequest createChuongTrinhHocRequest) {
        chuongTrinhHocService.save(createChuongTrinhHocRequest);
        return "redirect:/cth/";
    }
    @PostMapping(path = "/update",  consumes = "application/x-www-form-urlencoded")
    public String updateChuongTrinhHoc(Model model,@Valid @ModelAttribute("updateChuongTrinhHocRequest") UpdateChuongTrinhHocRequest updateChuongTrinhHocRequest) {
        chuongTrinhHocService.updateChuongTrinhHoc(updateChuongTrinhHocRequest);
        return "redirect:/cth/";
    }
    @GetMapping("/deleteCTH")
    public String deleteChuongTrinhHoc(@PathParam("id") Long id, Model model){
        chuongTrinhHocService.deleteChuongTrinhHocById(id);
        return "redirect:/cth/";
    }

    @GetMapping("/createDB")
    public void createDB() {
        for (int i = 1; i < 5; i++) {
            CreateChuongTrinhHocRequest newChuongTrinhHoc =
                    new CreateChuongTrinhHocRequest(
                            "cth a" + i,
                            "description " + i,
                            "link anh bia " + i,
                            LocalDate.now(),
                            LocalDate.now().plusDays(7L),
                            "Noi dung la " + i*23233,
                            (long) (i*123)
                    );
            chuongTrinhHocService.save(newChuongTrinhHoc);
        }
    }
}
