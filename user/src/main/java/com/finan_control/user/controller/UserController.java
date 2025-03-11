package com.finan_control.user.controller;

import com.finan_control.user.dtos.UserRecordDto;
import com.finan_control.user.model.UserModel;
import com.finan_control.user.repoitory.UserRepository;
import com.finan_control.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);
        this.userService.save(userModel);
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }
}
