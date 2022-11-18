package com.example.mamnoncvn.ClassManager.service;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.ClassManager.models.mapper.CVN_ClassMapper;
import com.example.mamnoncvn.ClassManager.models.request.CreateClassRequest;
import com.example.mamnoncvn.ClassManager.models.request.UpdateClassRequest;
import com.example.mamnoncvn.ClassManager.repository.CVN_ClassRepository;
import com.example.mamnoncvn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CVN_ClassService {
    @Autowired
    CVN_ClassRepository cvn_classRepository;

    public List<CVN_Class> getAll() {
        return cvn_classRepository.findAll();
    }

    public CVN_Class save(CreateClassRequest createClassRequest) {
        CVN_Class cvn_class = CVN_ClassMapper.convertRequestCreateToEntity(createClassRequest);
        cvn_classRepository.save(cvn_class);
        return cvn_class;
    }

    public void deleteClassById(Long id) {
        if (cvn_classRepository.existsById(id)) {
            cvn_classRepository.deleteById(id);
        } else throw new NotFoundException("Not found class id: " + id);
    }

    public CVN_Class updateClass(UpdateClassRequest updateClassRequest) {
        CVN_Class oldClass = cvn_classRepository.findById(updateClassRequest.getId()).get();
        oldClass.setAge(updateClassRequest.getAge());
        oldClass.setDateEnded(updateClassRequest.getDateEnded());
        oldClass.setStatus(updateClassRequest.isStatus());
        oldClass.setName(updateClassRequest.getName());
        oldClass.setTenGiaoVien1(updateClassRequest.getTenGiaoVien1());
        oldClass.setTenGiaoVien2(updateClassRequest.getTenGiaoVien2());
        oldClass.setDateStarted(updateClassRequest.getDateStarted());
        oldClass.setTuition(updateClassRequest.getTuition());
        oldClass.setTotalStudent(updateClassRequest.getTotalStudent());
        cvn_classRepository.saveAndFlush(oldClass);

        return oldClass;
    }



}
