package com.example.mamnoncvn.accountManager.accountPH.model.mapper;

import com.example.mamnoncvn.accountManager.accountPH.entity.PhuHuynhAccount;
import com.example.mamnoncvn.accountManager.accountPH.model.request.CreatePhuHuynhAccountRequest;
import com.example.mamnoncvn.accountManager.accountPH.model.request.UpdatePhuHuynhAccountRequest;
import com.example.mamnoncvn.accountManager.roles.ERole;
import com.example.mamnoncvn.accountManager.roles.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PhuHuynhAccountMapper {
    @Autowired
    private static PasswordEncoder passwordEncoder;
    public static  PhuHuynhAccount convertCreateRequestToEntity(CreatePhuHuynhAccountRequest createPhuHuynhAccountRequest) {
        PhuHuynhAccount phuHuynhAccount = new PhuHuynhAccount();
        phuHuynhAccount.setTenPhuHuynh(createPhuHuynhAccountRequest.getTenPhuHuynh());
        phuHuynhAccount.setStudentId(createPhuHuynhAccountRequest.getStudentId());
        phuHuynhAccount.setEmail(createPhuHuynhAccountRequest.getEmail());
        phuHuynhAccount.setDiaChi(createPhuHuynhAccountRequest.getDiaChi());
        phuHuynhAccount.setUsername(createPhuHuynhAccountRequest.getUsername());
        phuHuynhAccount.setPassword(createPhuHuynhAccountRequest.getPassword());
        phuHuynhAccount.setEnable(createPhuHuynhAccountRequest.isEnable());
        phuHuynhAccount.setSoDienThoai(createPhuHuynhAccountRequest.getSoDienThoai());
        phuHuynhAccount.setRole(String.valueOf(ERole.ROLE_USER));
        return phuHuynhAccount;
    }
    public static PhuHuynhAccount convertUpdateRequestToEntity(PhuHuynhAccount phuHuynhAccount, UpdatePhuHuynhAccountRequest createPhuHuynhAccountRequest) {
        phuHuynhAccount.setTenPhuHuynh(createPhuHuynhAccountRequest.getTenPhuHuynh());
        phuHuynhAccount.setStudentId(createPhuHuynhAccountRequest.getStudentId());
        phuHuynhAccount.setEmail(createPhuHuynhAccountRequest.getEmail());
        phuHuynhAccount.setDiaChi(createPhuHuynhAccountRequest.getDiaChi());
        phuHuynhAccount.setUsername(createPhuHuynhAccountRequest.getUsername());
        phuHuynhAccount.setRole(String.valueOf(ERole.ROLE_USER));
        phuHuynhAccount.setEnable(createPhuHuynhAccountRequest.isEnable());
        phuHuynhAccount.setSoDienThoai(createPhuHuynhAccountRequest.getSoDienThoai());

        return phuHuynhAccount;
    }
}
