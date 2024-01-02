package com.example.Base;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BookType implements Serializable{
    private String name;
    private Integer id;
    public BookType(String Name,Integer Id){
        this.name=Name;
        this.id=Id;
    }
    public BookType(){
        this.name="";
        this.id=0;
    }
    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map toMap(){
        Map map=new HashMap();
        map.put("Name",name);
        map.put("Id",id);
        return map;
    }
}
