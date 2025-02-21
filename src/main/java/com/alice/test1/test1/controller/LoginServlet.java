package com.alice.test1.test1.controller;

import com.alice.test1.test1.Service.impl.LoginServiceImpl;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
private LoginServiceImpl loginService=new LoginServiceImpl();

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
    String username=request.getParameter("username");
    String password=request.getParameter("password");

    boolean isAuthenticated=loginService.login(username,password);
    if (isAuthenticated){
        response.sendRedirect("Alicedashboard.jsp");
    }else {
        response.sendRedirect("AliceLogin.html");
    }
}
}
