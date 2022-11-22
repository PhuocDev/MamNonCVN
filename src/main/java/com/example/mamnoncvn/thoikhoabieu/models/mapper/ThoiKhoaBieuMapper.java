package com.example.mamnoncvn.thoikhoabieu.models.mapper;

import com.example.mamnoncvn.ClassManager.models.request.CreateClassRequest;
import com.example.mamnoncvn.thoikhoabieu.entity.ThoiKhoaBieu;
import com.example.mamnoncvn.thoikhoabieu.models.request.CreateThoiKhoaBieuRequest;
import com.example.mamnoncvn.thoikhoabieu.models.request.UpdateThoiKhoaBieuRequest;
import java.time.LocalDate;

public class ThoiKhoaBieuMapper {

    public static ThoiKhoaBieu convertRequestCreateToEntity(CreateThoiKhoaBieuRequest createThoiKhoaBieuRequest) {
        ThoiKhoaBieu thoiKhoaBieu = new ThoiKhoaBieu();
        thoiKhoaBieu.setDescription(createThoiKhoaBieuRequest.getDescription());
        thoiKhoaBieu.setAnhBia(createThoiKhoaBieuRequest.getAnhBia());
        thoiKhoaBieu.setNoiDung(createThoiKhoaBieuRequest.getNoiDung());
        thoiKhoaBieu.setStatus(true);
        thoiKhoaBieu.setNgayBatDau(createThoiKhoaBieuRequest.getNgayBatDau());
        thoiKhoaBieu.setNgayKetThuc(createThoiKhoaBieuRequest.getNgayKetThuc());
        thoiKhoaBieu.setNgayDang(LocalDate.now());
        thoiKhoaBieu.setTenTKB(createThoiKhoaBieuRequest.getTenTKB());
        thoiKhoaBieu.setMaLop(createThoiKhoaBieuRequest.getMaLop());
        return thoiKhoaBieu;
    }
    public static ThoiKhoaBieu convertRequestUpdateToEntity(UpdateThoiKhoaBieuRequest updateThoiKhoaBieuRequest) {
        ThoiKhoaBieu thoiKhoaBieu = new ThoiKhoaBieu();
        thoiKhoaBieu.setDescription(updateThoiKhoaBieuRequest.getDescription());
        thoiKhoaBieu.setAnhBia(updateThoiKhoaBieuRequest.getAnhBia());
        thoiKhoaBieu.setNoiDung(updateThoiKhoaBieuRequest.getNoiDung());
        thoiKhoaBieu.setStatus(updateThoiKhoaBieuRequest.isStatus());
        thoiKhoaBieu.setNgayBatDau(updateThoiKhoaBieuRequest.getNgayBatDau());
        thoiKhoaBieu.setNgayKetThuc(updateThoiKhoaBieuRequest.getNgayKetThuc());
        thoiKhoaBieu.setNgayDang(LocalDate.now());
        thoiKhoaBieu.setTenTKB(updateThoiKhoaBieuRequest.getTenTKB());
        thoiKhoaBieu.setMaLop(updateThoiKhoaBieuRequest.getMaLop());
        return thoiKhoaBieu;
    }

}
