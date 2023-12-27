package com.example.controller;

import com.example.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    public TextField BookidText;

    @FXML
    public TextField BooknameText;
    private Book originBook;
    public ManageController manageController;

    @FXML
    public void Add(ActionEvent event) {
        String name=BooknameText.getText();
        String author=BookauthorText.getText();
        String address=BookaddressText.getText();
        int count=Integer.parseInt(BookcountText.getText());
        int id=Integer.parseInt(BookidText.getText());
        Book book = new Book(name, id, author, address,count);
        HttpMethod.deleteBook(originBook);
        HttpMethod.addBook(book);
        try{
            Stage now=(Stage)Addbook.getScene().getWindow();
            now.close();
            manageController.refresh();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void loadData(){
        BooknameText.setText(originBook.Bookname);
        BookauthorText.setText(originBook.Bookauthor);
        BookaddressText.setText(originBook.Bookaddress);
        BookcountText.setText(String.valueOf(originBook.Bookcount));
        BookidText.setText(String.valueOf(originBook.Bookid));
    }
    public void setOriginBook(Book book){
        this.originBook=book;
    }
    public void setTableController(ManageController manageController){
        this.manageController=manageController;
    }
}
