package com.example.Base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Proxy(lazy = false)
public class UserInfo implements Serializable {


    private String username;

    private String password;

    private String level;
    private Integer userId;

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
        this.level="user";
    }

    public UserInfo(String username, String password,String level,int userId) {
        this.username = username;
        this.password = password;
        this.level=level;
        this.userId=userId;
    }

    public UserInfo() {
        this.username = "";
        this.password = "";
        this.level="user";
        this.userId=0;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLevel() {
        return level;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Map toMap(){
        Map map=new HashMap();
        map.put("username",username);
        map.put("password",password);
        map.put("level",level);
        map.put("userId",userId);
        return map;
    }
}

