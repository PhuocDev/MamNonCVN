package com.example.mamnoncvn.customer.service;

import com.example.mamnoncvn.customer.entity.Customer;
import com.example.mamnoncvn.customer.models.mapper.CustomerMapper;
import com.example.mamnoncvn.customer.models.request.CreateCustomerRequest;
import com.example.mamnoncvn.customer.models.request.UpdateCustomerRequest;
import com.example.mamnoncvn.customer.repository.CustomerRepository;
import com.example.mamnoncvn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            return customerRepository.getById(id);
        }
        else throw  new NotFoundException("Cannot found customer id: " + id);
    }

    public Customer save(CreateCustomerRequest createCustomerRequest) {
        Customer newCustomer = CustomerMapper.convertCreateCustomerRequestToEntity(createCustomerRequest);
        customerRepository.save(newCustomer);
        return newCustomer;
    }

    public void updateCustomer(UpdateCustomerRequest updateCustomerRequest){
        Customer oldCustomer = customerRepository.getById(updateCustomerRequest.getId());
        oldCustomer.setGhiChu(updateCustomerRequest.getGhiChu());
        oldCustomer.setStatus(updateCustomerRequest.getStatus());
        customerRepository.saveAndFlush(oldCustomer);
    }

    public void insertNewCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = CustomerMapper.convertCreateCustomerRequestToEntity(createCustomerRequest);
        customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else throw new NotFoundException("Can not found customer id " + id);
    }

    public List<Customer> findAllByKeyword(String keyword) {
        return customerRepository.findAllByKeyword(keyword);
    }
}
