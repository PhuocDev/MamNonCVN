package com.example.mamnoncvn.thoikhoabieu.service;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.ClassManager.models.mapper.CVN_ClassMapper;
import com.example.mamnoncvn.ClassManager.models.request.CreateClassRequest;
import com.example.mamnoncvn.ClassManager.models.request.UpdateClassRequest;
import com.example.mamnoncvn.ClassManager.repository.CVN_ClassRepository;
import com.example.mamnoncvn.exception.BadRequestException;
import com.example.mamnoncvn.exception.NotFoundException;
import com.example.mamnoncvn.thoikhoabieu.entity.ThoiKhoaBieu;
import com.example.mamnoncvn.thoikhoabieu.models.mapper.ThoiKhoaBieuMapper;
import com.example.mamnoncvn.thoikhoabieu.models.request.CreateThoiKhoaBieuRequest;
import com.example.mamnoncvn.thoikhoabieu.models.request.UpdateThoiKhoaBieuRequest;
import com.example.mamnoncvn.thoikhoabieu.repository.ThoiKhoaBieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ThoiKhoaBieuService {
    @Autowired
    ThoiKhoaBieuRepository thoiKhoaBieuRepository;

    public List<ThoiKhoaBieu> getAll() {
        return thoiKhoaBieuRepository.findAll();
    }

    public ThoiKhoaBieu save(CreateThoiKhoaBieuRequest createThoiKhoaBieuRequest) {
        ThoiKhoaBieu thoiKhoaBieu = ThoiKhoaBieuMapper.convertRequestCreateToEntity(createThoiKhoaBieuRequest);
        if (thoiKhoaBieu.getNgayBatDau().isAfter(thoiKhoaBieu.getNgayKetThuc())){
            throw new BadRequestException("Date created must be before date ended");
        }
        thoiKhoaBieuRepository.save(thoiKhoaBieu);
        return thoiKhoaBieu;
    }

    public void deleteThoiKhoaBieuById(Long id) {
        if (thoiKhoaBieuRepository.existsById(id)) {
            thoiKhoaBieuRepository.deleteById(id);
        } else throw new NotFoundException("Not found ThoiKhoaBieu id: " + id);
    }

    public ThoiKhoaBieu updateThoiKhoaBieu(UpdateThoiKhoaBieuRequest updateThoiKhoaBieuRequest) {
        ThoiKhoaBieu thoiKhoaBieu = thoiKhoaBieuRepository.findById(updateThoiKhoaBieuRequest.getId()).get();
        thoiKhoaBieu.setDescription(updateThoiKhoaBieuRequest.getDescription());
        thoiKhoaBieu.setAnhBia(updateThoiKhoaBieuRequest.getAnhBia());
        thoiKhoaBieu.setNoiDung(updateThoiKhoaBieuRequest.getNoiDung());
        thoiKhoaBieu.setStatus(updateThoiKhoaBieuRequest.isStatus());
        thoiKhoaBieu.setNgayBatDau(updateThoiKhoaBieuRequest.getNgayBatDau());
        thoiKhoaBieu.setNgayKetThuc(updateThoiKhoaBieuRequest.getNgayKetThuc());
        thoiKhoaBieu.setNgayDang(LocalDate.now());
        thoiKhoaBieu.setTenTKB(updateThoiKhoaBieuRequest.getTenTKB());
        thoiKhoaBieuRepository.saveAndFlush(thoiKhoaBieu);

        return thoiKhoaBieu;
    }


    public ThoiKhoaBieu findThoiKhoaBieuByID(Long id) {
        if (!thoiKhoaBieuRepository.existsById(id)) {
            throw new NotFoundException("Not found ThoiKhoaBieu id: " + id);
        }
        return thoiKhoaBieuRepository.findById(id).get();
    }

    public List<ThoiKhoaBieu> findAllByKeyword(String keyword) {
        //return thoiKhoaBieuRepository.findAll();
        return thoiKhoaBieuRepository.findAllByKeyword(keyword);
    }
}
