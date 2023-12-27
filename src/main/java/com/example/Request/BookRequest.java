package com.example.Request;

public class BookRequest {
    private String Kind;
    private String Info;
    public void setKind(String Kind){
        this.Kind = Kind;
    }
    public String getKind(){
        return this.Kind;
    }
    public void setInfo(String Info){
        this.Info = Info;
    }
    public String getInfo(){
        return this.Info;
    }
    public BookRequest(String Kind, String Info){
        this.Kind = Kind;
        this.Info = Info;
    }
}
