package com.example.Base;


import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.HttpMethod;
public class Book implements Serializable{

    //定义变量
    private String bookname;
    private int bookid;
    private String bookauthor;
    private String bookaddress;

    private int bookcount;
    private int bookType;
    public Book(String Bookname,int Bookid,String Bookauthor,String Bookaddress,int Bookcount,int BookType){
        this.bookname=Bookname;
        this.bookid=Bookid;
        this.bookauthor=Bookauthor;
        this.bookaddress=Bookaddress;
        this.bookcount=Bookcount;
        this.bookType=BookType;
    }
    public Book(){
        this.bookaddress=new String();
        this.bookauthor=new String();
        this.bookname=new String();
        this.bookid=0;
        this.bookcount=0;
        this.bookType=0;

    }
    public int getBookcount() {
        return bookcount;
    }

    public String getBookaddress() {
        return bookaddress;
    }

    public String getBookname() {
        return bookname;
    }

    public int getBookid() {
        return bookid;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookaddress(String bookaddress) {
        this.bookaddress = bookaddress;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public void setBookcount(int bookcount) {
        this.bookcount = bookcount;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }
    public Book(String Bookname,String Bookauthor,String Bookaddress,int Bookcount,int BookType){
        this.bookname=Bookname;
        this.bookauthor=Bookauthor;
        this.bookaddress=Bookaddress;
        this.bookcount=Bookcount;
        this.bookType=BookType;
    }

    public Map toMap(){
        Map res=new HashMap();
        res.put("Bookname",this.bookname);
        res.put("Bookid",Integer.toString(this.bookid));
        res.put("Bookauthor",this.bookauthor);
        res.put("Bookaddress",this.bookaddress);
        res.put("Bookcount",Integer.toString(this.bookcount));
        String BookType=HttpMethod.searchType(this.bookType).getName();
        res.put("BookType",BookType);
        return res;
    }

}
