package com.example.controller;

import java.util.ArrayList;

import com.example.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class choice {

    @FXML
    public Button check;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    ObservableList<String> BookList = FXCollections.observableArrayList();
    ArrayList<Book> books;
    public ManageController manageController;

    public void initialize(){
        books=HttpMethod.getAll("all");
        for(int i=0;i<books.size();i++){
            BookList.add(books.get(i).Bookname);
        }
        choiceBox.setItems(BookList);
        
    }
    @FXML
    public void okActhon(ActionEvent event) {
        String name=choiceBox.getValue();
        Book book=null;
        for(int i=0;i<books.size();i++){
            if(books.get(i).Bookname.equals(name)){
                book=books.get(i);
                break;
            }
        }
        HttpMethod.deleteBook(book);
        try{
            manageController.refresh();
            Stage now=(Stage)check.getScene().getWindow();
            now.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void setTableController(ManageController manageController){
        this.manageController=manageController;
    }
}
