package com.myCoursework.userManagementSystem.dao;

import com.myCoursework.userManagementSystem.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
    private String username="root";
    private String password="";
    private String connUrl="jdbc:mysql://localhost:3306/usermanagementsystem";
    private static Connection connection;
    
    
    private static final String INSERT_USER_SQL ="INSERT INTO user" +" (name,email,password,phone,sex,age) VALUES " +"(?,?,?,?,?,?);";
    private static final String SELECT_USER_BY_ID = "select userId,name,email,password,phone,sex,age from user where userId = ?";
    private static final String SELECT_ALL_USER = "select * from user";
    private static final String DELETE_USER_SQL = "DELETE FROM user WHERE userId = ?;";
    private static final String UPDATE_USER_SQL = "UPDATE user SET name = ?,email = ?,password = ?,phone = ?,sex = ?,age = ? WHERE userId = ?;";
    
    public UserDAO(){}
    
    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connUrl, username, password);
        }catch(Exception e){
            System.out.println(e);
        }
        return connection; 
        
    }
    //create or insert user
    public void insertUser(User user)throws SQLException{   
        try{
            Connection connection=getConnection();
                PreparedStatement preparedStatement =connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setLong(4,user.getPhone());
            preparedStatement.setString(5,user.getSex());
            preparedStatement.setInt(6,user.getAge());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public boolean updateUser(User user)throws SQLException{ 
        boolean rowUpdated;
        try( Connection connection=getConnection();
                PreparedStatement statement =connection.prepareStatement(UPDATE_USER_SQL);){
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setLong(4, user.getPhone());
            statement.setString(5, user.getSex());
            statement.setInt(6, user.getAge()); 
            statement.setInt(7,user.getUserId());
            
            
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;  
    }   
    public boolean deleteUser(int userId) throws SQLException{
        boolean rowDeleted;
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);){
            statement.setInt(1, userId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public User selectUser(int userId){
        User user = null;
        try(Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
            preparedStatement.setInt(1,userId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                long phone = rs.getLong("phone");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                user = new User(userId,name,email,password,phone,sex,age);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
    
    public List<User> selectAllUser(){
        List<User> user = new ArrayList<>();
        try(Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                int userId = rs.getInt("userId");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                long phone = rs.getLong("phone");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                user.add(new User(userId,name,email,password,phone,sex,age));
            }
        }catch(SQLException e){
            printSQLException(e);
        }
        return user;
    }
    private void printSQLException(SQLException ex){
        for(Throwable e: ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
