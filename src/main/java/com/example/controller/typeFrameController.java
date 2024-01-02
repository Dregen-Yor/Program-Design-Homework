package com.example.controller;

import java.util.ArrayList;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.control.cell.MapValueFactory;

import com.example.HttpMethod;
import com.example.Main;
import com.example.Base.*;
public class typeFrameController {

    @FXML
    public TableView<Map> Table;

    @FXML
    public TableColumn<Map, Button> Typeedit;

    @FXML
    public TableColumn<Map, String> Typeid;

    @FXML
    public Button newKind;

    @FXML
    public TableColumn<Map, String> typeName;

    @FXML
    public ObservableList<Map> list= FXCollections.observableArrayList();

    private ArrayList<BookType> bookTypes=new ArrayList<>();

    @FXML
    void onNewKind(ActionEvent event) {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("editType.fxml"));
        Stage stage=new Stage();
        try {
            Scene scene=new Scene(loader.load());
            stage.setTitle("新增种类");
            stage.setScene(scene);
            stage.initOwner(Main.getMainStage());
            stage.setOnCloseRequest(event1 -> {
                try{
                    this.refresh();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            editTypeController controller=loader.getController();
            controller.setModule(false);
            controller.setOrigin(new BookType());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(){
        Typeid.setCellValueFactory(new MapValueFactory<>("Id"));
        typeName.setCellValueFactory(new MapValueFactory<>("Name"));
        Typeedit.setCellValueFactory(new MapValueFactory<>("edit"));
        
        loadData();
    }

    public void editItem(BookType bookType){
        FXMLLoader loader =new FXMLLoader(getClass().getResource("editType.fxml"));
        Stage stage=new Stage();
        try {
            Scene scene=new Scene(loader.load());
            stage.setTitle("编辑名称");
            stage.setScene(scene);
            stage.initOwner(Main.getMainStage());
            editTypeController controller=loader.getController();
            controller.setOrigin(bookType);
            controller.setModule(true);
            stage.setOnCloseRequest(event -> {
                try{
                    this.refresh();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadData(){
        
        bookTypes=HttpMethod.getallType();
        for(int i=0;i<bookTypes.size();i++){
            Map map=bookTypes.get(i).toMap();
            Button button=new Button("编辑");
            button.setId(Integer.toString(i));
            button.setOnAction(event -> {
                String id=((Button)event.getSource()).getId();
                editItem(bookTypes.get(Integer.parseInt(id)));
            });
            map.put("edit",button);
            list.add(map);
        }
        Table.setItems(list);
    }
    public void refresh(){
        this.Table.getItems().clear();
        list.clear();
        loadData();
    }
    @FXML
    public void onRefresh(ActionEvent event){
        refresh();
    }
}
