package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewBookcontroller {

     @FXML
    public Button Addbook;
    public TextField BookaddressText;
    public TextField BooknameText;
    public TextField BookauthorText;
    public TextField BookidText;
    public TextField BookcountText;
    public ManageController manageController;
    public void Add(ActionEvent event) {
        String Bookname = BooknameText.getText();
        String Bookauthor = BookauthorText.getText();
        String Bookid = BookidText.getText();
        String Bookcount = BookcountText.getText();
        String Bookaddress = BookaddressText.getText();
        Book book = new Book(Bookname, Integer.parseInt(Bookid), Bookauthor,  Bookaddress,Integer.parseInt(Bookcount));
        try{
            Main.connect.sendMessage("addBook");
            Main.connect.sendObject(book);
        }catch( Exception e){
            e.printStackTrace();
        }
        Stage now = (Stage) Addbook.getScene().getWindow();
        now.close();
        try{
            manageController.refresh();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void setTableController(ManageController manageController){
        this.manageController=manageController;
    }
    
}
