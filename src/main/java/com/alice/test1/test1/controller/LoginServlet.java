package com.alice.test1.test1.controller;

import com.alice.test1.test1.Service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
private LoginServiceImpl loginService=new LoginServiceImpl();

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException{
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
