package com.example.mamnoncvn.customer.controller;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.ClassManager.models.request.CreateClassRequest;
import com.example.mamnoncvn.ClassManager.models.request.UpdateClassRequest;
import com.example.mamnoncvn.customer.entity.Customer;
import com.example.mamnoncvn.customer.models.mapper.CustomerMapper;
import com.example.mamnoncvn.customer.models.request.CreateCustomerRequest;
import com.example.mamnoncvn.customer.models.request.UpdateCustomerRequest;
import com.example.mamnoncvn.customer.service.CustomerService;
import com.example.mamnoncvn.mailSender.EmailService;
import com.example.mamnoncvn.mailSender.Mail;
import com.example.mamnoncvn.users.entity.AdminEmail;
import com.example.mamnoncvn.users.entity.User;
import com.example.mamnoncvn.users.repository.AdminEmailRepository;
import com.example.mamnoncvn.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/createDB")
    public List<Customer> createDB() {
        for (int i = 1; i < 4; i++) {
            CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest(
                    "Nguyễn Demo " + i, i+1, "Phụ huynh "+ i*123,
                    "Nghề số " + i,
                    "0986470758", "email" + i + "@gmail.com",
                    "Địa chỉ số " + i, "Ghi chú + " + i);
            customerService.insertNewCustomer(createCustomerRequest);
        }
        return customerService.getAll();
    }

    @GetMapping(path = {"/"})
    public String index(Model model, @RequestParam(required = false) String keyword) {
        List<Customer> customerList = customerService.getAll();
        if (keyword != null) {
            customerList = customerService.findAllByKeyword(keyword);
        }
        model.addAttribute("customerList", customerList);

        CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
        model.addAttribute("createCustomerRequest", createCustomerRequest);

        UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest();
        model.addAttribute("updateCustomerRequest", updateCustomerRequest);

        String searchKeyword = null;
        model.addAttribute("keyword", searchKeyword);
        return "admin/customer";
    }


    @PostMapping(path = "/add",  consumes = "application/x-www-form-urlencoded")
    public String addNewcustomer(Model model,@Valid @ModelAttribute("createCustomerRequest") CreateCustomerRequest createCustomerRequest) {
        customerService.save(createCustomerRequest);
        return "redirect:/admin/customer/";
    }
    @PostMapping(path = "/addFromClient",  consumes = "application/x-www-form-urlencoded")
    public String addNewcustomerFromClient(Model model,@Valid @ModelAttribute("createCustomerRequest") CreateCustomerRequest createCustomerRequest) {
        customerService.save(createCustomerRequest);
        try {
            List<AdminEmail> adminEmailList = adminEmailRepository.findAll();
            Mail mail = new Mail();
            mail.setSubject("Một phụ huynh vừa đăng kí tư vấn");
            for (int i =0; i< adminEmailList.size();i++){
                mail.setRecipient(adminEmailList.get(i).getEmail());
                mail.setAttachment(null);
                mail.setMsgBody("Thông tin khách hàng" +
                        "\nTên khách hàng: " + createCustomerRequest.getTenPhuHuynh() +
                        "\nTên bé: " + createCustomerRequest.getTenBe() +
                        "\nĐộ tuổi: " + createCustomerRequest.getTuoiBe() +
                        "\nSố điện thoại: " + createCustomerRequest.getSoDienThoai()+
                        "\nĐịa chỉ: " + createCustomerRequest.getDiaChi() +
                        "\nGhi chú: " + createCustomerRequest.getGhiChu() +
                        "\nNgày đăng kí: " + LocalDateTime.now()
                );
                emailService.sendSimpleMail(mail);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/client/";
    }
    @Autowired
    EmailService emailService;
    @Autowired
    AdminEmailRepository adminEmailRepository;
    private void sendMail(CreateCustomerRequest customer){
        List<AdminEmail> adminEmailList = adminEmailRepository.findAll();
        Mail mail = new Mail();
        mail.setSubject("Một phụ huynh vừa đăng kí tư vấn");

        for (int i =0; i< adminEmailList.size();i++){
            mail.setRecipient(adminEmailList.get(i).getEmail());
            mail.setAttachment(null);
            mail.setMsgBody("Thông tin khách hàng" +
                    "\nTên phụ huynh: " + customer.getTenPhuHuynh() +
                    "\nTên bé: " + customer.getTenBe() +
                    "\nĐộ tuổi: " + customer.getTuoiBe() +
                    "\nSố điện thoại: " + customer.getSoDienThoai()+
                    "\nĐịa chỉ: " + customer.getDiaChi() +
                    "\nNgày đăng kí: " + LocalDateTime.now()
            );
        }
        emailService.sendSimpleMail(mail);
    }
    @PostMapping(path = "/update",  consumes = "application/x-www-form-urlencoded")
    public String updateCustomer(Model model,@Valid @ModelAttribute("updateCustomerRequest") UpdateCustomerRequest updateCustomerRequest) {
        customerService.updateCustomer(updateCustomerRequest);
        return "redirect:/admin/customer/";
    }
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@PathParam("id") Long id, Model model){
        customerService.deleteCustomerById(id);
        return "redirect:/admin/customer/";
    }

}
