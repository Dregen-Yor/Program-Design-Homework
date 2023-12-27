package com.example.controller;

import com.example.*;
import com.example.Request.BookRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

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
    private BookRequest bookRequest;
    @FXML
    public void loadData() throws Exception{
        BookList = FXCollections.observableArrayList();
        ArrayList<Book> booklist= HttpMethod.getBook(this.bookRequest);
        for(int i=0;i<booklist.size();i++){
            ShowBook book=new ShowBook(booklist.get(i));
            BookList.add(book);
        }
        Bookname.setCellValueFactory(new PropertyValueFactory<>("Bookname"));
        Bookid.setCellValueFactory(new PropertyValueFactory<>("Bookid"));
        Bookauthor.setCellValueFactory(new PropertyValueFactory<>("Bookauthor"));
        Bookaddress.setCellValueFactory(new PropertyValueFactory<>("Bookaddress"));
        Bookcount.setCellValueFactory(new PropertyValueFactory<>("Bookcount"));

        Table.setItems(BookList);
    }

    public void setBookRequest(BookRequest bookRequest) {
        this.bookRequest = bookRequest;
    }
}
