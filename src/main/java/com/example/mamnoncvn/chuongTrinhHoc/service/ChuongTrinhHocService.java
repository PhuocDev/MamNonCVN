package com.example.mamnoncvn.chuongTrinhHoc.service;

import com.example.mamnoncvn.chuongTrinhHoc.entity.ChuongTrinhHoc;
import com.example.mamnoncvn.chuongTrinhHoc.models.mapper.ChuongTrinhHocMapper;
import com.example.mamnoncvn.chuongTrinhHoc.models.request.CreateChuongTrinhHocRequest;
import com.example.mamnoncvn.chuongTrinhHoc.models.request.UpdateChuongTrinhHocRequest;
import com.example.mamnoncvn.chuongTrinhHoc.repository.ChuongTrinhHocRepository;
import com.example.mamnoncvn.exception.BadRequestException;
import com.example.mamnoncvn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChuongTrinhHocService {

    @Autowired
    ChuongTrinhHocRepository chuongTrinhHocRepository;

    public List<ChuongTrinhHoc> getAll() {
        return chuongTrinhHocRepository.findAll();
    }

    public ChuongTrinhHoc save(CreateChuongTrinhHocRequest createChuongTrinhHocRequest) {
        ChuongTrinhHoc chuongTrinhHoc = ChuongTrinhHocMapper.convertRequestCreateToEntity(createChuongTrinhHocRequest);
        if (chuongTrinhHoc.getNgayBatDau().isAfter(chuongTrinhHoc.getNgayKetThuc())){
            throw new BadRequestException("Date created must be before date ended");
        }
        chuongTrinhHocRepository.save(chuongTrinhHoc);
        return chuongTrinhHoc;
    }

    public void deleteChuongTrinhHocById(Long id) {
        if (chuongTrinhHocRepository.existsById(id)) {
            chuongTrinhHocRepository.deleteById(id);
        } else throw new NotFoundException("Not found ChuongTrinhHoc id: " + id);
    }

    public ChuongTrinhHoc updateChuongTrinhHoc(UpdateChuongTrinhHocRequest updateChuongTrinhHocRequest) {
        ChuongTrinhHoc chuongTrinhHoc = chuongTrinhHocRepository.findById(updateChuongTrinhHocRequest.getId()).get();
        chuongTrinhHoc.setDescription(updateChuongTrinhHocRequest.getDescription());
        chuongTrinhHoc.setAnhBia(updateChuongTrinhHocRequest.getAnhBia());
        chuongTrinhHoc.setNoiDung(updateChuongTrinhHocRequest.getNoiDung());
        chuongTrinhHoc.setStatus(updateChuongTrinhHocRequest.isStatus());
        chuongTrinhHoc.setNgayBatDau(updateChuongTrinhHocRequest.getNgayBatDau());
        chuongTrinhHoc.setNgayKetThuc(updateChuongTrinhHocRequest.getNgayKetThuc());
        chuongTrinhHoc.setNgayDang(LocalDate.now());
        chuongTrinhHoc.setTenCTH(updateChuongTrinhHocRequest.getTenCTH());
        chuongTrinhHocRepository.saveAndFlush(chuongTrinhHoc);

        return chuongTrinhHoc;
    }


    public ChuongTrinhHoc findChuongTrinhHocByID(Long id) {
        if (!chuongTrinhHocRepository.existsById(id)) {
            throw new NotFoundException("Not found ChuongTrinhHoc id: " + id);
        }
        return chuongTrinhHocRepository.findById(id).get();
    }

    public List<ChuongTrinhHoc> findAllByKeyword(String keyword) {
        return chuongTrinhHocRepository.findAllByKeyword(keyword);
    }
}
