package com.example.mamnoncvn.accountManager.accountPH.service;

import com.example.mamnoncvn.accountManager.accountPH.entity.PhuHuynhAccount;
import com.example.mamnoncvn.accountManager.accountPH.model.mapper.PhuHuynhAccountMapper;
import com.example.mamnoncvn.accountManager.accountPH.model.request.CreatePhuHuynhAccountRequest;
import com.example.mamnoncvn.accountManager.accountPH.model.request.UpdatePhuHuynhAccountRequest;
import com.example.mamnoncvn.accountManager.accountPH.repository.PhuHuynhRepository;
import com.example.mamnoncvn.accountManager.roles.Roles;
import com.example.mamnoncvn.exception.NotFoundException;
import com.example.mamnoncvn.student.entity.Student;
import com.example.mamnoncvn.student.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class PhuHuynhAccountService {
    @Autowired
    PhuHuynhRepository phuHuynhRepository;

    @Autowired
    StudentService studentService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<PhuHuynhAccount> getAll() {
        return phuHuynhRepository.findAll();
    }

    public void insertNewPHAccount(CreatePhuHuynhAccountRequest createPhuHuynhAccountRequest){
        PhuHuynhAccount phuHuynhAccount = new PhuHuynhAccount();
        phuHuynhAccount = PhuHuynhAccountMapper.convertCreateRequestToEntity(createPhuHuynhAccountRequest);
        phuHuynhRepository.save(phuHuynhAccount);
    }

    public void updatePHAccount(UpdatePhuHuynhAccountRequest updatePhuHuynhAccountRequest){
        PhuHuynhAccount phuHuynhAccount = phuHuynhRepository.findById(updatePhuHuynhAccountRequest.getId()).get();
        phuHuynhAccount = PhuHuynhAccountMapper.convertUpdateRequestToEntity(phuHuynhAccount, updatePhuHuynhAccountRequest);
        phuHuynhRepository.saveAndFlush(phuHuynhAccount);
    }

    public void deletePHaccountId(Long id){
        if (phuHuynhRepository.existsById(id)) {
            phuHuynhRepository.deleteById(id);
        } else throw new NotFoundException("Not found phu huynh id " + id);
    }

    public List<PhuHuynhAccount> findAllByKeyword(String keyword) {
        return phuHuynhRepository.findAllByKeyword(keyword);
    }


}
