package com.Chioseaua.springbootsecondapp;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class User {

    private String userID;
    private String password;
    private String hashedPassword;
    private boolean loginStatus = false;
    private LocalDateTime date;


    public void User() {
        Scanner scanner = new Scanner(System.in);
        this.userID= UUID.randomUUID().toString();
        System.out.println("Introduceti parola: ");
        this.password = scanner.nextLine();
        this.hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        this.date = LocalDateTime.now();
    }

    /*public void setPassword(String password) {
        this.password = password;
    }

    public void setHashedPassword() {
        this.hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }*/

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
    /*public void setUserID() {
        this.userID= UUID.randomUUID().toString();
    }*/

    public String getUserID() {
        return userID;
    }



    public boolean verifyLogin(String givenPassword) {
        if(BCrypt.checkpw(givenPassword, hashedPassword)) {
            System.out.println("Password matched. You are logged in");
            loginStatus = true;
        } else {
            System.out.println("Password did not match. You are not logged in");
            loginStatus = false;
        }
        return loginStatus;
    }

    @Override
    public String toString() {
        return "userID='" + userID + '\'' +
                ", loginStatus=" + loginStatus +
                ", date=" + date;
    }
}
