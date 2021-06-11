/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myCoursework.userManagementSystem.LoginRegistration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Register(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            long phone = Long.parseLong(request.getParameter("phone"));
            String sex = request.getParameter("sex");
            int age =Integer.parseInt(request.getParameter("age"));
            String sql = "INSERT INTO user(name,email,password,phone,sex,age) VALUES (?,?,?,?,?,?)";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/UserManagementSystem","root","");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setLong(4, phone);
            ps.setString(5, sex);
            ps.setInt(6, age);
            ps.executeUpdate();
            PrintWriter out = response.getWriter();
            response.sendRedirect("login.jsp"); 
            out.println("sucessfully registered");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
