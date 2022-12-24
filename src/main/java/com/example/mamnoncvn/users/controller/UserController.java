package com.example.mamnoncvn.users.controller;

import com.example.mamnoncvn.users.Models.request.CreateUserRequest;
import com.example.mamnoncvn.users.Models.request.UpdatePasswordRequest;
import com.example.mamnoncvn.users.entity.AdminEmail;
import com.example.mamnoncvn.users.entity.User;
import com.example.mamnoncvn.users.repository.AdminEmailRepository;
import com.example.mamnoncvn.users.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminEmailRepository adminEmailRepository;

    @GetMapping("/createDB")
    public String createDB(Model model){
        CreateUserRequest createUserRequest = new CreateUserRequest(
                "user",
                "user",
                "user@gmail.com",
                "0987654321",
                true,
                "modifier"
        );
        userService.insertNewUser(createUserRequest);
        return "redirect:/admin/user/";
    }
    @GetMapping(path = {"/", "/all"})
    public String indexUser(Model model) {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        UpdatePasswordRequest updatePasswordRequest = new UpdatePasswordRequest();
        model.addAttribute("createUserRequest",createUserRequest);
        model.addAttribute("updatePasswordRequest",updatePasswordRequest);

        List<User> userList = userService.getAll();
        model.addAttribute("userList", userList);
        return "admin/account";
    }
    @RequestMapping(path = "/add", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public String addNewUser(Model model, @Valid @ModelAttribute("createUserRequest")
                             CreateUserRequest createUserRequest) {
        userService.insertNewUser(createUserRequest);
        AdminEmail adminEmail = new AdminEmail(createUserRequest.getEmail());
        if (!adminEmailRepository.existsByEmail(createUserRequest.getEmail())){
            adminEmailRepository.save(adminEmail);
        }
        return "redirect:/admin/user/";
    }

    @PostMapping(path = "/update",  consumes = "application/x-www-form-urlencoded")
    public String updatePassword(Model model, @Valid @ModelAttribute("updatePasswordRequest")
                                 UpdatePasswordRequest updatePasswordRequest){
        System.out.println( updatePasswordRequest.getOldPassword());
        if(!userService.checkPass(updatePasswordRequest)) {
            return "error";
        }else {
            userService.updatePassword(updatePasswordRequest);
            return "redirect:/admin/user/";
        }
    }
    @GetMapping("/deleteUser")
    public String deleteCustomer(@PathParam("id") Long id, Model model){
        userService.deleteUserById(id);
        return "redirect:/admin/user/";
    }



}
