package com.example;
import java.io.*;

public class Book implements Serializable{
    private String Bookname,Bookauthor,Bookaddress;
    private int Bookcount,Bookid;
    public Book(String Bookname,String Bookauthor,String Bookaddress,int Bookcount,int Bookid){
        this.Bookname=Bookname;
        this.Bookauthor=Bookauthor;
        this.Bookaddress=Bookaddress;
        this.Bookcount=Bookcount;
        this.Bookid=Bookid;
    }

    
}
