package com.example.mamnoncvn.GiaoVienCVN.controllers;

import com.example.mamnoncvn.GiaoVienCVN.DTO.GiaoVienDTO;
import com.example.mamnoncvn.GiaoVienCVN.GiaoVien;
import com.example.mamnoncvn.GiaoVienCVN.GiaoVienRepository;
import com.example.mamnoncvn.GiaoVienCVN.service.GiaoVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/giaovien")
public class GiaoVienController {
    @Autowired
    GiaoVienService giaoVienService;

    @GetMapping("/createDB")
    public List<GiaoVien> createDB() {
        for (int i = 0; i < 5; i++) {
            GiaoVienDTO sampleData = new GiaoVienDTO("Nguyen Van A" + i*100, "Dia chi " + i+1, "0987" + i*12345 , true);
            giaoVienService.addNewGiaoVien(sampleData);
        }
        return giaoVienService.getAllGV();
    }

    @GetMapping("/")
    public List<GiaoVien> showALlGV() {
        return giaoVienService.getAllGV();
    }

}
