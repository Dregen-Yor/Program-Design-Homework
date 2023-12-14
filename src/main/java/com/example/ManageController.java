package com.example;

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
    public Button Addbook;

    @FXML
    public TextField BookaddressText;

    @FXML
    public TextField BooknameText;

    @FXML
    public TextField BookauthorText;

    @FXML
    public TextField BookidText;

    @FXML
    public TextField BookcountText;

    @FXML
    public void Add(ActionEvent event) {

    }

    @FXML
    public TableView<ShowBook> Table;

    @FXML
    public TableColumn<ShowBook, String> Bookauthor;

    @FXML
    public TableColumn<ShowBook, Integer> Bookid;

    @FXML
    public TableColumn<ShowBook, String> Bookaddress;

    @FXML
    public Button NewBook;

    @FXML
    public TableColumn<ShowBook, String> Bookname;

    @FXML
    public TableColumn<ShowBook, Integer> Bookcount;

    @FXML
    public void newbook(ActionEvent event) {
        //新建图书

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
        loadData();
    }
    public static void main(String[] args){
        //launch(args);
    }
}
