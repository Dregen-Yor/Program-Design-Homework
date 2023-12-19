package com.example;

import javafx.application.Application;
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
import javafx.scene.control.TextField;
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
        // System.out.println("success");
        Main.connect.sendMessage("getBookInfo");
        Book now=(Book) Main.connect.getObject();
        while(now!=null){
            BookList.add(new ShowBook(now));
            now=(Book) Main.connect.getObject();
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
    public static void main(String[] args){
        //launch(args);
    }
}
