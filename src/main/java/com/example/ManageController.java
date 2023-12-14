package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageController {

    @FXML
    private TableView<Book> Table;

    @FXML
    private TableColumn<Book, String> Bookauthor;

    @FXML
    private TableColumn<Book, Integer> Bookid;

    @FXML
    private TableColumn<Book, String> Bookaddress;

    @FXML
    private Button NewBook;

    @FXML
    private TableColumn<Book, String> Bookname;

    @FXML
    private TableColumn<Book, Integer> Bookcount;

    @FXML
    void newbook(ActionEvent event) {

    }
    ObservableList<Book> BookList = FXCollections.observableArrayList();
    @FXML
    public void initialize() throws Exception{
        loadData();
    }
    public void loadData() throws Exception{
        Main.connect.sendMessage("getBookInfo");
        Book now=(Book) Main.connect.getObject();
        while(now!=null){
            BookList.add(now);
            now=(Book) Main.connect.getObject();
        }
        Table.setItems(BookList);
    }
}
