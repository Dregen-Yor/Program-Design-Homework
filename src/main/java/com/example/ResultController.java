package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ResultController {
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
    ObservableList<ShowBook> BookList = null;
    @FXML
    public void initialize() throws Exception{
        loadData();
    }
    public void loadData() throws Exception{
        // System.out.println("success");
        Main.connect.sendMessage("getBookInfo");
        BookList = FXCollections.observableArrayList();
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
}
