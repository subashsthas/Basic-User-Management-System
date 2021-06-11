
package com.myCoursework.userManagementSystem.web;

import com.myCoursework.userManagementSystem.dao.UserDAO;
import com.myCoursework.userManagementSystem.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    public void  init() {
        userDAO =new UserDAO();
    }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);      
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       String action = request.getServletPath();
        try{
            switch(action){
                case "/new":
                    showNewForm(request,response);
                    break;
                case "/insert":
                    insertUser(request,response);
                    break;

                case "/delete":
                    deleteUser(request,response);  
                    break;
                case "/edit":
                    showEditForm(request,response);  
                    break;
                case "/update":
                    updateUser(request,response);
                    break;
                default:
                    listUser(request,response);
                    break;
            }
       }catch(SQLException ex){
           throw new ServletException(ex);
       }
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        long phone = Long.parseLong(request.getParameter("phone"));
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        User newUser = new User(name,email,password,phone,sex,age);
        userDAO.insertUser(newUser);
        response.sendRedirect("list");  
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException{
        int userId = Integer.parseInt(request.getParameter("userId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        long phone = Long.parseLong(request.getParameter("phone"));
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        
        User user = new User(userId,name,email,password,phone,sex,age);
        userDAO.updateUser(user);
        response.sendRedirect("list");  
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException{
        int userId = Integer.parseInt(request.getParameter("userId"));
        userDAO.deleteUser(userId);
        response.sendRedirect("list");
    }
    private void showEditForm (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int userId = Integer.parseInt(request.getParameter("userId"));
        User existingUser = userDAO.selectUser(userId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user",existingUser);
        dispatcher.forward(request, response);
    }
    private void listUser (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        List< User > listUser = userDAO.selectAllUser();
        request.setAttribute("listUser",listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }   
}
