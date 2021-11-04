package com.siliconspectra.controller;

import com.siliconspectra.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignupController extends HttpServlet {

    UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        boolean isValidate = userService.usernameValidate(username);

        PrintWriter out = resp.getWriter();
        out.print(isValidate);
    }
}
