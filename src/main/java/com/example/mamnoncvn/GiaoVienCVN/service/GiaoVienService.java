package com.example.mamnoncvn.GiaoVienCVN.service;

import com.example.mamnoncvn.GiaoVienCVN.DTO.GiaoVienDTO;
import com.example.mamnoncvn.GiaoVienCVN.GiaoVien;
import com.example.mamnoncvn.GiaoVienCVN.GiaoVienRepository;
import com.example.mamnoncvn.GiaoVienCVN.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoVienService {

    @Autowired
    GiaoVienRepository giaoVienRepository;

    @Autowired
    Validation giaoVienValidation;

    public List<GiaoVien> getAllGV() {
        return giaoVienRepository.findAll();
    }

    public GiaoVien getGiaoVienByID(Long id) {
        if (giaoVienRepository.existsById(id)) {
            return giaoVienRepository.findById(id).get();
        } else return null;
    }
    //this function should receive giaovienDTO
    public GiaoVien addNewGiaoVien(GiaoVienDTO giaoVienDTO) {
        //if DTO is valid
        if (giaoVienValidation.validateGiaoVienDTO(giaoVienDTO)) {
            // convert construction to convert from DTO to Entity
            GiaoVien giaoVien = new GiaoVien(giaoVienDTO);
            giaoVienRepository.save(giaoVien);
            return giaoVienRepository.findById(giaoVien.getId()).get();
        } else return null;
    }

    public void deleteGiaoVienById(Long id) {
        if (giaoVienRepository.existsById(id)) {
            giaoVienRepository.deleteById(id);
        }
    }
    public GiaoVien updateGiaoVien(GiaoVienDTO giaoVienDTO, Long id) {
        GiaoVien oldGV = giaoVienRepository.findById(id).get();

        if (giaoVienValidation.validateGiaoVienDTO(giaoVienDTO)) {
            oldGV.setHoTen(giaoVienDTO.getHoTen());
            oldGV.setDiaChi(giaoVienDTO.getDiaChi());
            oldGV.setStatus(giaoVienDTO.isStatus());
            oldGV.setSoDienThoai(giaoVienDTO.getSoDienThoai());
            giaoVienRepository.saveAndFlush(oldGV);
            return giaoVienRepository.findById(id).get();
        } else return null ;
    }


}
