package com.example.mamnoncvn.chuongTrinhHoc.models.mapper;

import com.example.mamnoncvn.chuongTrinhHoc.entity.ChuongTrinhHoc;
import com.example.mamnoncvn.chuongTrinhHoc.models.request.CreateChuongTrinhHocRequest;
import com.example.mamnoncvn.chuongTrinhHoc.models.request.UpdateChuongTrinhHocRequest;

import java.time.LocalDate;

public class ChuongTrinhHocMapper {
    public static ChuongTrinhHoc convertRequestCreateToEntity(CreateChuongTrinhHocRequest createChuongTrinhHocRequest) {
        ChuongTrinhHoc chuongTrinhHoc = new ChuongTrinhHoc();
        chuongTrinhHoc.setDescription(createChuongTrinhHocRequest.getDescription());
        chuongTrinhHoc.setAnhBia(createChuongTrinhHocRequest.getAnhBia());
        chuongTrinhHoc.setNoiDung(createChuongTrinhHocRequest.getNoiDung());
        chuongTrinhHoc.setStatus(true);
        chuongTrinhHoc.setNgayBatDau(createChuongTrinhHocRequest.getNgayBatDau());
        chuongTrinhHoc.setNgayKetThuc(createChuongTrinhHocRequest.getNgayKetThuc());
        chuongTrinhHoc.setNgayDang(LocalDate.now());
        chuongTrinhHoc.setTenCTH(createChuongTrinhHocRequest.getTenCTH());
        chuongTrinhHoc.setMaLop(createChuongTrinhHocRequest.getMaLop());
        return chuongTrinhHoc;
    }
    public static ChuongTrinhHoc convertRequestUpdateToEntity(UpdateChuongTrinhHocRequest updateChuongTrinhHocRequest) {
        ChuongTrinhHoc chuongTrinhHoc = new ChuongTrinhHoc();
        chuongTrinhHoc.setDescription(updateChuongTrinhHocRequest.getDescription());
        chuongTrinhHoc.setAnhBia(updateChuongTrinhHocRequest.getAnhBia());
        chuongTrinhHoc.setNoiDung(updateChuongTrinhHocRequest.getNoiDung());
        chuongTrinhHoc.setStatus(updateChuongTrinhHocRequest.isStatus());
        chuongTrinhHoc.setNgayBatDau(updateChuongTrinhHocRequest.getNgayBatDau());
        chuongTrinhHoc.setNgayKetThuc(updateChuongTrinhHocRequest.getNgayKetThuc());
        chuongTrinhHoc.setNgayDang(LocalDate.now());
        chuongTrinhHoc.setTenCTH(updateChuongTrinhHocRequest.getTenCTH());
        chuongTrinhHoc.setMaLop(updateChuongTrinhHocRequest.getMaLop());

        return chuongTrinhHoc;
    }
}
