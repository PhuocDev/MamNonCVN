package com.example.mamnoncvn.GiaoVienCVN.controllers;

import com.example.mamnoncvn.GiaoVienCVN.entity.GiaoVien;
import com.example.mamnoncvn.GiaoVienCVN.service.GiaoVienService;
import com.example.mamnoncvn.GiaoVienCVN.Models.request.CreateGiaoVienRequest;
import com.example.mamnoncvn.GiaoVienCVN.Models.request.UpdateGiaoVienRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/giaovien")
public class GiaoVienController {
    @Autowired
    GiaoVienService giaoVienService;

    @GetMapping("/createDB")
    public List<GiaoVien> createDB() {
        for (int i = 1; i < 5; i++) {
            CreateGiaoVienRequest sampleData = new CreateGiaoVienRequest("Nguyễn Hoàng A" + i*100, "Dia chi " + i+1, "0987" + i*123451, i*345 + "@gmail.com" , true);
            giaoVienService.addNewGiaoVien(sampleData);
        }
        return giaoVienService.getAllGV();
    }

    @GetMapping("/")
    public List<GiaoVien> showALlGV() {
        return giaoVienService.getAllGV();
    }

    @PostMapping( consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Object> insertNewGV(@Valid @ModelAttribute("giaovienRequest") CreateGiaoVienRequest giaoVienRequest) {
        //return giaoVienService.addNewGiaoVien(giaoVienDTO);
        return ResponseEntity.ok(giaoVienService.addNewGiaoVien(giaoVienRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGiaoVien(@PathVariable Long id) {
        giaoVienService.deleteGiaoVienById(id);
        return ResponseEntity.ok("Deleted giaovien id: " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGiaoVienProfile(@Valid @RequestBody UpdateGiaoVienRequest giaoVienRequest, @PathVariable Long id) {
        return ResponseEntity.ok(giaoVienService.updateGiaoVien(giaoVienRequest));
    }



}
