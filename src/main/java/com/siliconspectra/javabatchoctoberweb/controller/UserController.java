package com.siliconspectra.javabatchoctoberweb.controller;


import com.siliconspectra.javabatchoctoberweb.service.UserService;
import com.siliconspectra.javabatchoctoberweb.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/get")
    @ExceptionHandler
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUser();
            return new ResponseEntity<>(users,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody com.siliconspectra.javabatchoctoberweb.entity.User user) throws IOException {
        try {
            userService.createUser(user);
            return new ResponseEntity<>("insert success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("insert fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        try {
            userService.deleteUserById(id);
            return new ResponseEntity<>("delete success", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("delete fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody com.siliconspectra.javabatchoctoberweb.entity.User user) {
        try {
            userService.updateUser(id, user);
            return new ResponseEntity<>("update success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("update fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

