package com.example;

import com.example.Base.UserInfo;

public class Appstore {
    private static UserInfo user;
    public static String getRole(){
        return user.getLevel();
    }
    public static void setRole(UserInfo role){
        Appstore.user=role;
    }

    public static int getId(){
        return user.getUserId();
    }

    public static String getName(){
        return user.getUsername();
    }

    public static void setId(int id){
        user.setUserId(id);
    }

    public static void setName(String name){
        user.setUsername(name);
    }

    public static void setPass(String pass){
        user.setPassword(pass);
        
    }

    public static String getPass(){
        return user.getPassword();
    }

    public static void setLevel(String level){
        user.setLevel(level);
    }

    public static void setUserInfo(UserInfo userInfo){
        user=userInfo;
    }

}
