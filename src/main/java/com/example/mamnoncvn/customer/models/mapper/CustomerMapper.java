package com.example.mamnoncvn.customer.models.mapper;


import com.example.mamnoncvn.customer.entity.Customer;
import com.example.mamnoncvn.customer.models.request.CreateCustomerRequest;
import com.example.mamnoncvn.customer.models.request.UpdateCustomerRequest;
import com.example.mamnoncvn.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class CustomerMapper {
    public static Customer convertCreateCustomerRequestToEntity(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        customer.setDiaChi(createCustomerRequest.getDiaChi());
        customer.setGhiChu(createCustomerRequest.getGhiChu());
        customer.setNgheNghiep(createCustomerRequest.getNgheNghiep());
        customer.setSoDienThoai(createCustomerRequest.getSoDienThoai());
        customer.setTenBe(createCustomerRequest.getTenBe());
        customer.setTenPhuHuynh(createCustomerRequest.getTenPhuHuynh());
        customer.setSoDienThoai(createCustomerRequest.getSoDienThoai());
        customer.setEmail(createCustomerRequest.getEmail());
        customer.setTuoiBe(createCustomerRequest.getTuoiBe());
        //Vì khi khởi tạo người dùng không cần nhập thông tin dưới
        customer.setStatus(false);
        customer.setNgayDK(LocalDate.now());
        return customer;
    }
//    public static Customer convertUpdateCusRequestToEntity(UpdateCustomerRequest updateCustomerRequest) {
//        Customer customer = customerService.findCustomerById(updateCustomerRequest.getId());
//        customer.setStatus(updateCustomerRequest.getStatus());
//        customer.setGhiChu(updateCustomerRequest.getGhiChu());
//        return customer;
//    }
}
