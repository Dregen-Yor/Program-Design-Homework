package com.example.Base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.example.HttpMethod;

//@Proxy(lazy = false)
//@Entity
//@Table(name= "history")
public class History implements Serializable{

    private int user;
    private String time;
    private Integer book;
    private String status;
    private Integer id;

    public History(int user,String time,Integer book,String status,Integer id){
        this.user=user;
        this.time=time;
        this.book=book;
        this.status=status;
        this.id=id;
    }

    public History(int user,Integer book,String status){
        this.user=user;
        this.time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年-MM月-dd日 HH时:mm分:ss秒"));
        this.book=book;
        this.status=status;
    }
    public History(){
        this.book=0;
        this.status="";
        this.time="";
        this.user=0;
    }
    public int getUser() {
        return user;
    }
    public String getTime() {
        return time;
    }

    public Integer getBook() {
        return book;
    }

    public String getStatus() {
        return status;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map toMap(){
        Map map=new HashMap();
        map.put("user",HttpMethod.searchUserInfo(this.getUser()).getUsername());
        map.put("time",time);
        map.put("book",HttpMethod.getBook(book));
        map.put("status",status);
        map.put("id",id);
        return map;
    }
}
