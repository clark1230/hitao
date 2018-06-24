package com.hzitxx.hitao.entity;

import java.io.Serializable;

public class User implements Serializable{
    private Integer userId;
    private String username;
    private String gender;

    public User(Integer userId, String username, String gender) {
        this.userId = userId;
        this.username = username;
        this.gender = gender;
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
