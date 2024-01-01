package com.example.controller;

import java.util.ArrayList;

import com.example.*;
import com.example.Base.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class modifyBookcontroller {

    @FXML
    public Button Addbook;

    @FXML
    public TextField BookaddressText;

    @FXML
    public TextField BookauthorText;

    @FXML
    public TextField BookcountText;

    @FXML
    public TextField BooknameText;

    @FXML
    private ChoiceBox<BookType> bookTypeChoice;
    private Book originBook;
    public BookframeController manageController;

    @FXML
    public void Add(ActionEvent event) {
        String name=BooknameText.getText();
        String author=BookauthorText.getText();
        String address=BookaddressText.getText();
        int count=Integer.parseInt(BookcountText.getText());
        int Typeid=bookTypeChoice.getValue().getId();
        Book book=new Book(name,originBook.getBookid(),author,address,count,Typeid);
        HttpMethod.modifyBook(book);
        try{
            Stage now=(Stage)Addbook.getScene().getWindow();
            now.close();
            // manageController.refresh();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void loadData()throws Exception{
        BooknameText.setText(originBook.getBookname());
        BookauthorText.setText(originBook.getBookauthor());
        BookaddressText.setText(originBook.getBookaddress());
        BookcountText.setText(String.valueOf(originBook.getBookcount()));
        ArrayList<BookType> types=HttpMethod.getallType();
        ObservableList<BookType> typeList = FXCollections.observableArrayList();
        for(int i=0;i<types.size();i++){
            typeList.add(types.get(i));
        }
        bookTypeChoice.setItems(typeList);
        bookTypeChoice.setConverter(new javafx.util.StringConverter<BookType>() {
            @Override
            public String toString(BookType object) {
                return object.getName();
            }
            @Override
            public BookType fromString(String string) {
                return null;
            }
        });
        bookTypeChoice.setValue(HttpMethod.searchType(originBook.getBookType()));
    }
    public void setOriginBook(Book book){
        this.originBook=book;
    }
    public void setTableController(BookframeController manageController){
        this.manageController=manageController;
    }
}
