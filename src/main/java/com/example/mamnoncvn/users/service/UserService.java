package com.example.mamnoncvn.users.service;

import com.example.mamnoncvn.exception.NotFoundException;
import com.example.mamnoncvn.users.Models.mapper.UserMapper;
import com.example.mamnoncvn.users.Models.request.CreateUserRequest;
import com.example.mamnoncvn.users.Models.request.UpdatePasswordRequest;
import com.example.mamnoncvn.users.Models.request.UpdateUserRequest;
import com.example.mamnoncvn.users.entity.User;
import com.example.mamnoncvn.users.repository.RoleRepository;
import com.example.mamnoncvn.users.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public void insertNewUser(CreateUserRequest createUserRequest) {
        User newUser = new User();
        newUser = UserMapper.convertCreateRequestToEntity(newUser ,createUserRequest);
        userRepository.save(newUser);
    }

    public User updateUser(UpdateUserRequest updateUserRequest) {
        User oldUser = userRepository.findById(updateUserRequest.getId()).get();
        //update more here
        return oldUser;
    }
    public void updatePassword(UpdatePasswordRequest updatePasswordRequest){
            User user = userRepository.findById(updatePasswordRequest.getUserId()).get();
            user.setPassword(updatePasswordRequest.getNewPassword());
            userRepository.saveAndFlush(user);
    }
    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else throw new NotFoundException("Not found user id: "+ id);
    }

    public boolean checkPass(UpdatePasswordRequest updatePasswordRequest) {
        String oldPass = userRepository.findById(updatePasswordRequest.getUserId()).get().getPassword();
        String oldPasswordToConfirm = updatePasswordRequest.getOldPassword();
        if (oldPass.equals(oldPasswordToConfirm)){
            return true;
        } else return false;
    }

}
