package com.example.mamnoncvn.customer.controller;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.ClassManager.models.request.CreateClassRequest;
import com.example.mamnoncvn.ClassManager.models.request.UpdateClassRequest;
import com.example.mamnoncvn.customer.entity.Customer;
import com.example.mamnoncvn.customer.models.mapper.CustomerMapper;
import com.example.mamnoncvn.customer.models.request.CreateCustomerRequest;
import com.example.mamnoncvn.customer.models.request.UpdateCustomerRequest;
import com.example.mamnoncvn.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/customer")
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
        return "redirect:/customer/";
    }
    @PostMapping(path = "/update",  consumes = "application/x-www-form-urlencoded")
    public String updateCustomer(Model model,@Valid @ModelAttribute("updateCustomerRequest") UpdateCustomerRequest updateCustomerRequest) {
        customerService.updateCustomer(updateCustomerRequest);
        return "redirect:/customer/";
    }
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@PathParam("id") Long id, Model model){
        customerService.deleteCustomerById(id);
        return "redirect:/customer/";
    }

}
