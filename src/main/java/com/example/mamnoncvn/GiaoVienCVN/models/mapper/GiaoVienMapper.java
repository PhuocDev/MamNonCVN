package com.example.mamnoncvn.GiaoVienCVN.models.mapper;

import com.example.mamnoncvn.GiaoVienCVN.models.dto.GiaoVienDTO;
import com.example.mamnoncvn.GiaoVienCVN.models.request.CreateGiaoVienRequest;
import com.example.mamnoncvn.GiaoVienCVN.entity.GiaoVien;

public class GiaoVienMapper {
    public static GiaoVienDTO toGiaoVienDTO(GiaoVien giaoVien) {
        GiaoVienDTO giaoVienDTO = new GiaoVienDTO();
        giaoVienDTO.setDiaChi(giaoVien.getDiaChi());
        giaoVienDTO.setHoTen(giaoVien.getHoTen());
        giaoVienDTO.setSoDienThoai(giaoVien.getSoDienThoai());
        giaoVienDTO.setStatus(giaoVien.isStatus());
        giaoVienDTO.setEmail(giaoVien.getEmail());
        giaoVienDTO.setId(giaoVien.getId());

        return giaoVienDTO;
    }

    public static GiaoVien toGiaoVien (CreateGiaoVienRequest giaoVienRequest) {
        GiaoVien giaoVien = new GiaoVien();
        giaoVien.setHoTen(giaoVienRequest.getHoTen());
        giaoVien.setDiaChi(giaoVienRequest.getDiaChi());
        giaoVien.setSoDienThoai(giaoVienRequest.getSoDienThoai());
        giaoVien.setStatus(giaoVienRequest.isStatus());
        giaoVien.setEmail(giaoVienRequest.getEmail());

        return giaoVien;
    }


}
