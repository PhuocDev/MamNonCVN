package com.example.mamnoncvn.users.Models.mapper;

import com.example.mamnoncvn.users.Models.request.CreateUserRequest;
import com.example.mamnoncvn.users.Models.request.UpdatePasswordRequest;
import com.example.mamnoncvn.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {

    public static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static User convertCreateRequestToEntity(User user,CreateUserRequest createUserRequest) {
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(createUserRequest.getPassword()));
        user.setSoDienThoai(createUserRequest.getSoDienThoai());
        user.setStatus(createUserRequest.isStatus());
        user.setUsername(createUserRequest.getUsername());
        user.setRole(createUserRequest.getRole());
        return user;
    }

    public static User convertUpdatePasswordRequestToEntity(User user, UpdatePasswordRequest updatePasswordRequest){
        user.setPassword(updatePasswordRequest.getNewPassword());
        return user;
    }
}
