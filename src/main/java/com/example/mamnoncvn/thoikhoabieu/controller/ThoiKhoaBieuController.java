package com.example.mamnoncvn.thoikhoabieu.controller;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.ClassManager.models.request.CreateClassRequest;
import com.example.mamnoncvn.ClassManager.models.request.UpdateClassRequest;
import com.example.mamnoncvn.ClassManager.service.CVN_ClassService;
import com.example.mamnoncvn.GiaoVienCVN.entity.GiaoVien;
import com.example.mamnoncvn.thoikhoabieu.entity.ThoiKhoaBieu;
import com.example.mamnoncvn.thoikhoabieu.models.request.CreateThoiKhoaBieuRequest;
import com.example.mamnoncvn.thoikhoabieu.models.request.UpdateThoiKhoaBieuRequest;
import com.example.mamnoncvn.thoikhoabieu.service.ThoiKhoaBieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin/tkb")
public class ThoiKhoaBieuController {

    @Autowired
    ThoiKhoaBieuService thoiKhoaBieuService;
    @Autowired
    CVN_ClassService classService;

    @GetMapping(path = "/")
    public String index(Model model, @RequestParam(required = false) String keyword) {
        List<ThoiKhoaBieu> thoiKhoaBieuList = thoiKhoaBieuService.getAll();
        if (keyword != null) {
            thoiKhoaBieuList = thoiKhoaBieuService.findAllByKeyword(keyword);
        }

        model.addAttribute("danhSachTKB", thoiKhoaBieuList);
        CreateThoiKhoaBieuRequest createThoiKhoaBieuRequest = new CreateThoiKhoaBieuRequest();
        model.addAttribute("createThoiKhoaBieuRequest", createThoiKhoaBieuRequest);

        UpdateThoiKhoaBieuRequest updateThoiKhoaBieuRequest = new UpdateThoiKhoaBieuRequest();
        model.addAttribute("updateThoiKhoaBieuRequest", updateThoiKhoaBieuRequest);

        //searching function
        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);

        //class id insert
        List<CVN_Class> danhSachLop = classService.findAllWorkingClass();
        model.addAttribute("danhSachLop", danhSachLop);

        return "/admin/thoikhoabieu";
    }

    @PostMapping(path = "/add",  consumes = "application/x-www-form-urlencoded")
    public String addNewThoiKhoaBieu(Model model,@Valid @ModelAttribute("createThoiKhoaBieuRequest") CreateThoiKhoaBieuRequest createThoiKhoaBieuRequest) {
        thoiKhoaBieuService.save(createThoiKhoaBieuRequest);
        return "redirect:/admin/tkb/";
    }
    @PostMapping(path = "/update",  consumes = "application/x-www-form-urlencoded")
    public String updateThoiKhoaBieu(Model model,@Valid @ModelAttribute("updateThoiKhoaBieuRequest") UpdateThoiKhoaBieuRequest updateThoiKhoaBieuRequest) {
        thoiKhoaBieuService.updateThoiKhoaBieu(updateThoiKhoaBieuRequest);
        return "redirect:/admin/tkb/";
    }
    @GetMapping("/deleteTKB")
    public String deleteThoiKhoaBieu(@PathParam("id") Long id, Model model){
        thoiKhoaBieuService.deleteThoiKhoaBieuById(id);
        return "redirect:/admin/tkb/";
    }

    @GetMapping("/createDB")
    public void createDB() {
        for (int i = 1; i < 5; i++) {
            CreateThoiKhoaBieuRequest newThoiKhoaBieu =
                    new CreateThoiKhoaBieuRequest(
                            "TKB a" + i,
                            "description " + i,
                            "link anh bia " + i,
                            LocalDate.now(),
                            LocalDate.now().plusDays(7L),
                            "Noi dung la " + i*23233,
                            (long) (i*123)
                    );
            thoiKhoaBieuService.save(newThoiKhoaBieu);
        }
    }
}
