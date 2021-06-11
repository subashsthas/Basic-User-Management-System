/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myCoursework.userManagementSystem.model;

/**
 *
 * @author subash
 */
public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private long phone;
    private String sex;
    private int age;

    public User(int userId, String name, String email, String password, long phone, String sex, int age) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
    }

    public User(String name, String email, String password, long phone, String sex, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
