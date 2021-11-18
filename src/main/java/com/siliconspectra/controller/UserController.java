package com.siliconspectra.controller;


import com.google.gson.Gson;
import com.siliconspectra.entity.User;
import com.siliconspectra.service.UserService;
import com.siliconspectra.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @GetMapping("/get")
    public String getAllUsers()  {
        try {
            Gson gson = new Gson();
            return gson.toJson(userService.getAllUser());
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping(value = "/get/{id}")
    public String getUserById(@PathVariable String id, @RequestParam("name") String username) {
        try {
            Gson gson = new Gson();
            return gson.toJson(userService.getUserById(id));
        }catch (Exception e){
            return null;
        }
    }

    @PostMapping("/create")
    public String createUser(HttpServletRequest httpServletRequest) throws IOException {

        String requestBody = httpServletRequest.getReader().lines()
                .reduce("", (accumulator, actual) -> accumulator + actual);
        Gson gson = new Gson();
        User user = gson.fromJson(requestBody, User.class);
        return userService.createUser(user)? gson.toJson(new Response("insert success")) :
                gson.toJson(new Response("insert fail")) ;

    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        Gson gson = new Gson();
        userService.deleteUserById(id);
        return gson.toJson(new Response("insert success"));
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable String id, HttpServletRequest httpServletRequest) throws IOException {
        String requestBody = httpServletRequest.getReader().lines()
                .reduce("", (accumulator, actual) -> accumulator + actual);
        Gson gson = new Gson();
        userService.updateUser(id, gson.fromJson(requestBody, User.class));
        return gson.toJson(new Response("update success"));
    }
}
