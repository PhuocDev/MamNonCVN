package com.example.mamnoncvn.ClassManager.models.mapper;

import com.example.mamnoncvn.ClassManager.entity.CVN_Class;
import com.example.mamnoncvn.ClassManager.models.request.CreateClassRequest;
import com.example.mamnoncvn.ClassManager.models.request.UpdateClassRequest;

public class CVN_ClassMapper {
    public static CVN_Class convertRequestCreateToEntity(CreateClassRequest createClassRequest) {
        CVN_Class cvn_class = new CVN_Class();
        cvn_class.setAge(createClassRequest.getAge());
        cvn_class.setDateEnded(createClassRequest.getDateEnded());
        cvn_class.setStatus(createClassRequest.isStatus());
        cvn_class.setName(createClassRequest.getName());
        cvn_class.setTenGiaoVien1(createClassRequest.getTenGiaoVien1());
        cvn_class.setTenGiaoVien2(createClassRequest.getTenGiaoVien2());
        cvn_class.setDateStarted(createClassRequest.getDateStarted());
        cvn_class.setTuition(createClassRequest.getTuition());
        cvn_class.setTotalStudent(createClassRequest.getTotalStudent());

        return cvn_class;
    }
    public static CVN_Class convertRequestUpdateToEntity(UpdateClassRequest updateClassRequest) {
        CVN_Class cvn_class = new CVN_Class();
        cvn_class.setAge(updateClassRequest.getAge());
        cvn_class.setDateEnded(updateClassRequest.getDateEnded());
        cvn_class.setStatus(updateClassRequest.isStatus());
        cvn_class.setName(updateClassRequest.getName());
        cvn_class.setTenGiaoVien1(updateClassRequest.getTenGiaoVien1());
        cvn_class.setTenGiaoVien2(updateClassRequest.getTenGiaoVien2());
        cvn_class.setDateStarted(updateClassRequest.getDateStarted());
        cvn_class.setTuition(updateClassRequest.getTuition());
        cvn_class.setTotalStudent(updateClassRequest.getTotalStudent());

        return cvn_class;
    }


}
