package com.example.controller;

import java.util.ArrayList;
import java.util.Map;

import com.example.*;
import com.example.Base.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

public class BookframeController {

    @FXML
    public TableColumn<Map, String> BookType;

    @FXML
    public TableColumn<Map, String> Bookaddress;

    @FXML
    public TableColumn<Map, String> Bookauthor;

    @FXML
    public TableColumn<Map, String> Bookcount;

    @FXML
    public TableColumn<Map, String> Bookid;

    @FXML
    public TableColumn<Map, String> Bookname;

    @FXML
    public TableColumn<Map, Button> Bookdelete;

    @FXML
    public TableColumn<Map, Button> Bookedit;

    @FXML
    public TableView<Map> Table;

    @FXML
    public Button choice;

    @FXML
    public Button newBook;

    @FXML
    public Button query;

    @FXML
    public TextField queryname;

    @FXML
    public ChoiceBox<BookType> typeChoice;

    private String queryName="";

    private Integer queryType=-1;

    private ArrayList<Book> bookList=null;

    @FXML
    public void onChoice(ActionEvent event) throws Exception{
        BookType type=typeChoice.getValue();
        if(type==null){
            queryType=-1;
        }
        else{
            queryType=typeChoice.getValue().getId();
        }
        refresh();
    }

    @FXML
    public void onNewBook(ActionEvent event) {
        //新建图书
        Stage stage=new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("addBook.fxml"));
        try{
            Scene scene=new Scene(loader.load());
            stage.setTitle("新建图书");
            stage.setScene(scene);
            stage.setAlwaysOnTop(true);
            stage.initOwner(Main.getMainStage());
            stage.setOnCloseRequest(event1 -> {
                try{
                    Main.setCanClose(true);
                    refresh();
                }catch(Exception e){
                    e.printStackTrace();
                }
            });
            Main.setCanClose(false);
            stage.show();
            newBookcontroller=loader.getController();
            newBookcontroller.setTableController(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void onQuery(ActionEvent event) throws Exception{
        queryName=queryname.getText();
        refresh();
    }

    private NewBookcontroller newBookcontroller=null;
    private modifyBookcontroller modifyBookcontroller=null;

    public ObservableList<Map> BookList= FXCollections.observableArrayList();
    @FXML
    public void initialize() throws Exception{
        Bookname.setCellValueFactory(new MapValueFactory<>("Bookname"));
        Bookid.setCellValueFactory(new MapValueFactory<>("Bookid"));
        Bookauthor.setCellValueFactory(new MapValueFactory<>("Bookauthor"));
        Bookaddress.setCellValueFactory(new MapValueFactory<>("Bookaddress"));
        Bookcount.setCellValueFactory(new MapValueFactory<>("Bookcount"));
        Bookedit.setCellValueFactory(new MapValueFactory<>("Bookedit"));
        Bookdelete.setCellValueFactory(new MapValueFactory<>("Bookdelete"));
        BookType.setCellValueFactory(new MapValueFactory<>("BookType"));
        String role=Appstore.getRole();
        if(role.equals("admin")){
            Bookedit.setText("编辑");
            Bookdelete.setText("删除");
        }
        else{
            Bookedit.setText("借阅");
            Bookdelete.setText("归还");
            newBook.setVisible(false);
        }
        
        loadData();
    }

    private void editItem(Book book){
        Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("modify.fxml"));
        stage.setTitle("修改图书");
        stage.initOwner(Main.getMainStage());
        try{
            stage.setScene(new Scene(loader.load()));
            stage.setAlwaysOnTop(true);
            stage.setOnCloseRequest(event -> {
                try{
                    Main.setCanClose(true);
                    refresh();
                }catch(Exception e){
                    e.printStackTrace();
                }
            });
            Main.setCanClose(false);
            modifyBookcontroller=loader.getController();
            modifyBookcontroller.setOriginBook(book);
            modifyBookcontroller.loadData();
            stage.show();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    ObservableList<BookType> typeList = FXCollections.observableArrayList();
    public void loadData() throws Exception{
        Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ArrayList<BookType> types=HttpMethod.getallType();
        for(int i=0;i<types.size();i++){
            typeList.add(types.get(i));
        }
        typeChoice.setItems(typeList);
        typeChoice.setValue(new BookType());
        typeChoice.setConverter(new StringConverter<BookType>() {
            @Override
            public String toString(BookType object) {
                if(object==null){
                    return "";
                }
                return object.getName();
            }
            @Override
            public BookType fromString(String string) {
                return null;
            }
        });
        bookList=HttpMethod.getAllBook("all");
        String role=Appstore.getRole();
        for(int i=0;i<bookList.size();i++){
            Book now = (Book)bookList.get(i);
            if(queryType==-1||now.getBookType()==queryType){
                if(now.getBookname().contains(queryName)||queryName.equals("")||queryName==null){
                    Map map=now.toMap();
                    if(role.equals("admin")){
                        Button btn=new Button("编辑");
                        btn.setId(Integer.toString(i));
                        btn.setOnAction(event -> {
                            String idnum=((Button)event.getSource()).getId();
                            int Idnum=Integer.parseInt(idnum);
                            Book book = bookList.get(Idnum);
                            this.editItem(book);
                        });
                        
                        map.put("Bookedit",btn);
                        btn=new Button("删除");
                        btn.setId(Integer.toString(i));
                        btn.setOnAction(event -> {
                            String idnum=((Button)event.getSource()).getId();
                            int Idnum=Integer.parseInt(idnum);
                            Book book = bookList.get(Idnum);
                            try{
                                HttpMethod.deleteBook(book);
                                System.out.println("delete"+book.getBookname());
                                refresh();
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        });
                        map.put("Bookdelete",btn);
                    }
                    else{
                        boolean flag=HttpMethod.historyExist(now);
                        Button btn=new Button("借阅");
                        btn.setId(Integer.toString(i));
                        btn.setOnAction(event -> {
                            String idnum=((Button)event.getSource()).getId();
                            int Idnum=Integer.parseInt(idnum);
                            Book book = bookList.get(Idnum);
                            try{
                                borrow(book);
                                refresh();
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        });
                        btn.setDisable(flag);
                        map.put("Bookedit",btn);
                        btn=new Button("归还");
                        btn.setId(Integer.toString(i));
                        btn.setOnAction(event -> {
                            String idnum=((Button)event.getSource()).getId();
                            int Idnum=Integer.parseInt(idnum);
                            Book book = bookList.get(Idnum);
                            try{
                                returnBook(book);
                                refresh();
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        });
                        btn.setDisable(!flag);
                        map.put("Bookdelete",btn);
                    }
                    
                    BookList.addAll(FXCollections.observableArrayList(map));
                }
            }
        }
        
        Table.setItems(BookList);
    }

    public void borrow(Book book){
        if(book.getBookcount()==0){
            MessageDialog.showDialog("库存不足");
            return;
        }
        int count=book.getBookcount();
        book.setBookcount(count-1);
        try{
            HttpMethod.modifyBook(book);
            History history=new History(Appstore.getId(),book.getBookid(),"借阅中");
            HttpMethod.addHistory(history);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void returnBook(Book book){
        int count=book.getBookcount();
        book.setBookcount(count+1);
        try{
            HttpMethod.modifyBook(book);
            History history=HttpMethod.findhistory(book);
            history.setStatus("已归还");
            HttpMethod.modifyHistory(history);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void refresh()throws Exception{
        Table.getItems().clear();
        typeChoice.getItems().clear();
        loadData();
    }
    @FXML
    public void onRefresh(ActionEvent event)throws Exception{
        queryName="";
        queryType=-1;
        refresh();
    }

}
