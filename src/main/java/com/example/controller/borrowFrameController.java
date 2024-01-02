package com.example.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;

import com.example.Appstore;
import com.example.HttpMethod;
import com.example.Base.*;

import cn.hutool.db.meta.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.util.StringConverter;

public class borrowFrameController {

    @FXML
    public ChoiceBox<Book> bookChoice;

    @FXML
    public TableColumn<Map, String> bookColumn;

    @FXML
    public Button button1;

    @FXML
    public Button button2;

    @FXML
    public TableColumn<Map, Integer> idColumn;

    @FXML
    public Label lb1;
    
    @FXML
    public TableView<Map> Table;


    @FXML
    public TableColumn<Map, String> statusColumn;

    @FXML
    public TableColumn<Map, String> timeColumn;

    @FXML
    public ChoiceBox<UserInfo> userChoice;

    @FXML
    public TableColumn<Map, String> userColumn;

    @FXML
    public Integer userquery=-1;

    public String bookquery="";
    public void onQueryuser(ActionEvent event) {
        userquery=userChoice.getValue().getUserId();
        refresh();
    }

    @FXML
    public void onQuerybook(ActionEvent event) {
        Book tmp=bookChoice.getValue();
        if(tmp==null){
            bookquery="";
        }
        else{
            bookquery=tmp.getBookname();
        }
        refresh();
    }
    private ArrayList<Book> books;
    private ArrayList<UserInfo> users;
    private ArrayList<History> histories;
    public ObservableList<Map> list= FXCollections.observableArrayList();
    public ObservableList<Book> booklist= FXCollections.observableArrayList();
    public ObservableList<UserInfo> userlist= FXCollections.observableArrayList();
    public void initialize(){
        idColumn.setCellValueFactory(new MapValueFactory<>("id"));
        userColumn.setCellValueFactory(new MapValueFactory<>("user"));
        bookColumn.setCellValueFactory(new MapValueFactory<>("book"));
        timeColumn.setCellValueFactory(new MapValueFactory<>("time"));
        statusColumn.setCellValueFactory(new MapValueFactory<>("status"));
        if(Appstore.getRole().equals("user")){
            lb1.setVisible(false);
            userChoice.setVisible(false);
            button1.setVisible(false);
            userquery=Appstore.getId();
        }
        loadData();
    }
    @FXML
    public void onRefresh(ActionEvent event){
        userquery=-1;
        bookquery="";
        refresh();
    }
    void refresh(){
        Table.getItems().clear();
        bookChoice.getItems().clear();
        userChoice.getItems().clear();
        loadData();
    }
    public void loadData(){
        this.books=HttpMethod.getAllBook("");
        this.users=HttpMethod.getAllusers();
        this.histories=HttpMethod.getAllHistory();
        for(int i=0;i<books.size();i++){
            booklist.add(books.get(i));
        }
        for(int i=0;i<users.size();i++){
            userlist.add(users.get(i));
        }
        bookChoice.setItems(booklist);
        bookChoice.setValue(new Book());
        bookChoice.setConverter(new StringConverter<Book>() {
            @Override
            public String toString(Book object) {
                if(object==null){
                    return "";
                }
                return object.getBookname();
            }

            @Override
            public Book fromString(String string) {
                return null;
            }
        });

        userChoice.setItems(userlist);
        userChoice.setValue(new UserInfo());
        userChoice.setConverter(new StringConverter<UserInfo>() {
            @Override
            public String toString(UserInfo object) {
                if(object==null){
                    return "";
                }
                return object.getUsername();
            }

            @Override
            public UserInfo fromString(String string) {
                return null;
            }
        });

        for(int i=0;i<histories.size();i++){
            History now = histories.get(i);
            if (userquery!=-1&&now.getUser()!=userquery) {
                continue;
            }
            if(bookquery!=""&&!HttpMethod.getBook(now.getBook()).getBookname().equals(bookquery)){
                continue;
            }
            list.add(now.toMap());
            Table.setItems(list);
        }
    }
}
