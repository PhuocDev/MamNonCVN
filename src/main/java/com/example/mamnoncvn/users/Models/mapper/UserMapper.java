package com.example.mamnoncvn.users.Models.mapper;

import com.example.mamnoncvn.users.Models.request.CreateUserRequest;
import com.example.mamnoncvn.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {

    public static User convertCreateRequestToEntity(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        user.setSoDienThoai(createUserRequest.getSoDienThoai());
        user.setStatus(createUserRequest.isStatus());
        user.setUsername(createUserRequest.getUsername());

        return user;
    }
}
