package com.pethaven.model;

/**
 * Model class for User credentials. 
 * Essential for the Linear Search login logic [cite: 2026-01-15].
 */
public class UserModel {
    private String username;
    private String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}