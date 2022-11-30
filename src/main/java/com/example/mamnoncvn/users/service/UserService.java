package com.example.mamnoncvn.users.service;

import com.example.mamnoncvn.exception.NotFoundException;
import com.example.mamnoncvn.users.Models.request.CreateUserRequest;
import com.example.mamnoncvn.users.Models.request.UpdateUserRequest;
import com.example.mamnoncvn.users.entity.User;
import com.example.mamnoncvn.users.repository.RoleRepository;
import com.example.mamnoncvn.users.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User insertNewUser(CreateUserRequest createUserRequest) {
        ModelMapper modelMapper = new ModelMapper();
        User newUser = new User();
        newUser = modelMapper.map(createUserRequest, User.class);
        userRepository.save(newUser);
        return newUser;
    }

    public User updateUser(UpdateUserRequest updateUserRequest) {
        User oldUser = userRepository.findById(updateUserRequest.getId()).get();
        //update more here

        return oldUser;
    }
    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else throw new NotFoundException("Not found userid: "+ id);
    }

}
