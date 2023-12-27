package com.example.controller;

import java.util.ArrayList;

import com.example.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageController {

    @FXML
    public TableView<ShowBook> Table;
    public NewBookcontroller newBookcontroller=null;
    @FXML
    public TableColumn<ShowBook, String> Bookauthor;

    @FXML
    public TableColumn<ShowBook, Integer> Bookid;

    @FXML
    public TableColumn<ShowBook, String> Bookaddress;

    @FXML
    public TableColumn<ShowBook, String> Bookname;

    @FXML
    public TableColumn<ShowBook, Integer> Bookcount;

    @FXML
    public Button NewBook;
    @FXML
    public Button DeleteBook;

    @FXML
    public Button ModifyBook;
    public void newbook(ActionEvent event) {
        //新建图书
        Stage stage=new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("addBook.fxml"));
        try{
            Scene scene=new Scene(loader.load());
            stage.setTitle("新建图书");
            stage.setScene(scene);
            stage.show();
            newBookcontroller=loader.getController();
            newBookcontroller.setTableController(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    ObservableList<ShowBook> BookList = FXCollections.observableArrayList();
    @FXML
    public void initialize() throws Exception{
        loadData();
    }
    public void loadData() throws Exception{
        ArrayList booklist=HttpMethod.getAll("all");
        for(int i=0;i<booklist.size();i++){
            Book now = (Book)booklist.get(i);
            BookList.add(new ShowBook(now));
        }
        Bookname.setCellValueFactory(new PropertyValueFactory<>("Bookname"));
        Bookid.setCellValueFactory(new PropertyValueFactory<>("Bookid"));
        Bookauthor.setCellValueFactory(new PropertyValueFactory<>("Bookauthor"));
        Bookaddress.setCellValueFactory(new PropertyValueFactory<>("Bookaddress"));
        Bookcount.setCellValueFactory(new PropertyValueFactory<>("Bookcount"));

        Table.setItems(BookList);
    }
    public void refresh() throws Exception{
        Table.getItems().clear();
        loadData();
    }
    @FXML
    void ModifyBook(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("choiceStage2.fxml"));
        try{
            Scene scene=new Scene(loader.load());
            Stage stage=new Stage();
            stage.setTitle("选择要修改的图书");
            stage.setScene(scene);
            stage.show();
            choice2 choice2=loader.getController();
            choice2.setTableController(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void deleteBook(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("choiceStage.fxml"));
        try{
            Scene scene=new Scene(loader.load());
            Stage stage=new Stage();
            stage.setTitle("选择要删除的图书");
            stage.setScene(scene);
            stage.show();
            choice choice=loader.getController();
            choice.setTableController(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        //launch(args);
    }
}
