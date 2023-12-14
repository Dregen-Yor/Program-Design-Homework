package com.example;

import javafx.beans.property.*;

public class ShowBook {
    public SimpleStringProperty Bookname;
    public SimpleIntegerProperty Bookid;
    public SimpleStringProperty Bookauthor;
    public SimpleStringProperty Bookaddress;
    public SimpleIntegerProperty Bookcount;
    public ShowBook(Book book){
        this.Bookname=new SimpleStringProperty(book.Bookname);
        this.Bookid=new SimpleIntegerProperty(book.Bookid);
        this.Bookauthor=new SimpleStringProperty(book.Bookauthor);
        this.Bookaddress=new SimpleStringProperty(book.Bookaddress);
        this.Bookcount=new SimpleIntegerProperty(book.Bookcount);
    }
    public String getBookname(){
        return Bookname.get();
    }
    public void setBookname(String Bookname){
        this.Bookname.set(Bookname);
    }
    public int getBookid(){
        return Bookid.get();
    }
    public void setBookid(int Bookid){
        this.Bookid.set(Bookid);
    }
    public String getBookauthor(){
        return Bookauthor.get();
    }
    public void setBookauthor(String Bookauthor){
        this.Bookauthor.set(Bookauthor);
    }
    public String getBookaddress(){
        return Bookaddress.get();
    }
    public void setBookaddress(String Bookaddress){
        this.Bookaddress.set(Bookaddress);
    }
    public int getBookcount(){
        return Bookcount.get();
    }
    public void setBookcount(int Bookcount){
        this.Bookcount.set(Bookcount);
    }
    
}
