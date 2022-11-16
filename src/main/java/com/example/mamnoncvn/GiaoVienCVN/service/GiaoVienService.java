package com.example.mamnoncvn.GiaoVienCVN.service;

import com.example.mamnoncvn.GiaoVienCVN.entity.GiaoVien;
import com.example.mamnoncvn.GiaoVienCVN.models.mapper.GiaoVienMapper;
import com.example.mamnoncvn.GiaoVienCVN.models.request.CreateGiaoVienRequest;
import com.example.mamnoncvn.GiaoVienCVN.models.request.UpdateGiaoVienRequest;
import com.example.mamnoncvn.GiaoVienCVN.repository.GiaoVienRepository;
import com.example.mamnoncvn.exception.BadRequestException;
import com.example.mamnoncvn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoVienService {

    @Autowired
    GiaoVienRepository giaoVienRepository;


    public List<GiaoVien> getAllGV() {
        return giaoVienRepository.findAll();
    }

    public GiaoVien getGiaoVienByID(Long id) {
        if (giaoVienRepository.existsById(id)) {
            return giaoVienRepository.findById(id).get();
        } else return null;
    }
    //this function should receive giaovienDTO
    public GiaoVien addNewGiaoVien(CreateGiaoVienRequest giaoVienRequest) {
        GiaoVien giaoVien = giaoVienRepository.findByhoTen(giaoVienRequest.getHoTen());
        if (giaoVien != null) {
            throw new BadRequestException("Giao vien đã tồn tại trong hệ thống. Vui lòng nhập họ tên khác khac");
        }
        giaoVien = GiaoVienMapper.toGiaoVien(giaoVienRequest);
        giaoVienRepository.save(giaoVien);

        return giaoVien;
    }

    public void deleteGiaoVienById(Long id) {
        if (giaoVienRepository.existsById(id)) {
            giaoVienRepository.deleteById(id);
        } else throw new NotFoundException("Giao vien ID not found");
    }
    public GiaoVien updateGiaoVien(UpdateGiaoVienRequest updateGVrequest) {
        if (!giaoVienRepository.existsById(updateGVrequest.getId())) throw new NotFoundException("Not found giaovien id: " + updateGVrequest.getId());
        GiaoVien oldGV = giaoVienRepository.findById(updateGVrequest.getId()).get();
            oldGV.setHoTen(updateGVrequest.getHoTen());
            oldGV.setDiaChi(updateGVrequest.getDiaChi());
            oldGV.setStatus(updateGVrequest.isStatus());
            oldGV.setSoDienThoai(updateGVrequest.getSoDienThoai());
            oldGV.setEmail(updateGVrequest.getEmail());
            giaoVienRepository.saveAndFlush(oldGV);
            return giaoVienRepository.findById(oldGV.getId()).get();
    }



}
