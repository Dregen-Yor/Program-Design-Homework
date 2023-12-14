package com.example;
import java.io.*;
public class Book implements Serializable{

    //定义变量
    public String Bookname;
    public int Bookid;
    public String Bookauthor;
    public String Bookaddress;
    public int Bookcount;
    public Book(String Bookname,int Bookid,String Bookauthor,String Bookaddress,int Bookcount){
        this.Bookname=Bookname;
        this.Bookid=Bookid;
        this.Bookauthor=Bookauthor;
        this.Bookaddress=Bookaddress;
        this.Bookcount=Bookcount;
    }
}
