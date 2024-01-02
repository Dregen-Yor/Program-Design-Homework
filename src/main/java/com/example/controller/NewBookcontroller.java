package com.example.controller;

import com.example.Base.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.HttpMethod;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.StringConverter;

public class NewBookcontroller {

     @FXML
    public Button Addbook;
    public TextField BookaddressText;
    public TextField BooknameText;
    public TextField BookauthorText;
    public TextField BookcountText;
    @FXML
    private ChoiceBox<BookType> typeChoiceBox;
    public BookframeController manageController;
    public void Add(ActionEvent event) {
        String Bookname = BooknameText.getText();
        String Bookauthor = BookauthorText.getText();
        String Bookcount = BookcountText.getText();
        String Bookaddress = BookaddressText.getText();
        BookType BookType=typeChoiceBox.getValue();
        Book book = new Book(Bookname, Bookauthor,  Bookaddress,Integer.parseInt(Bookcount),BookType.getId());
        try{
            HttpMethod.addBook(book);
            manageController.refresh();
        }catch( Exception e){
            e.printStackTrace();
        }
        Stage now = (Stage) Addbook.getScene().getWindow();
        now.fireEvent(new WindowEvent(now, WindowEvent.WINDOW_CLOSE_REQUEST));
        try{
            manageController.refresh();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void setTableController(BookframeController manageController){
        this.manageController=manageController;
    }
    ObservableList<BookType> typeList = FXCollections.observableArrayList();
    public void initialize(){
        ArrayList<BookType> types=HttpMethod.getallType();
        for(int i=0;i<types.size();i++){
            typeList.add(types.get(i));
        }
        typeChoiceBox.setItems(typeList);
        typeChoiceBox.setConverter(new StringConverter<BookType>() {
            @Override
            public String toString(BookType object) {
                return object.getName();
            }

            @Override
            public BookType fromString(String string) {
                return null;
            }
        });
    }
    
}
