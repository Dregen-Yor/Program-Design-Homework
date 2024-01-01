package com.example.controller;

import java.util.ArrayList;
import java.util.Map;

import com.example.HttpMethod;
import com.example.Main;
import com.example.Base.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.cell.MapValueFactory;

public class userFrameController {

    @FXML
    public TableView<Map> Table;

    @FXML
    public TableColumn<Map, Button> editTable;

    @FXML
    public TableColumn<Map, String> levelTable;

    @FXML
    public TableColumn<Map, String> passwordTable;

    @FXML
    public TableColumn<Map, Integer> userIdTable;

    @FXML
    public TableColumn<Map,String> usernameTable;

    @FXML
    public Button newUser;


    private ArrayList<UserInfo> users;

    public ObservableList<Map> userList= FXCollections.observableArrayList();

    @FXML
    public void onNewUser(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("new-user.fxml"));
        Stage stage =new Stage();
        try{
            Scene scene=new Scene(loader.load());
            stage.setTitle("新建用户");
            stage.setScene(scene);
            stage.initOwner(Main.getMainStage());
            Main.setCanClose(false);
            stage.setOnCloseRequest(event1 -> {
                Main.setCanClose(true);
            });
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void initialize(){

        userIdTable.setCellValueFactory(new MapValueFactory<>("userId"));
        usernameTable.setCellValueFactory(new MapValueFactory<>("username"));
        passwordTable.setCellValueFactory(new MapValueFactory<>("password"));
        levelTable.setCellValueFactory(new MapValueFactory<>("level"));
        editTable.setCellValueFactory(new MapValueFactory<>("edit"));
        loadData();
    }
    public void editItem(UserInfo user){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modify-password.fxml"));
        Stage stage =new Stage();
        try{
            Scene scene=new Scene(loader.load());
            stage.setTitle("修改密码");
            stage.setScene(scene);
            stage.initOwner(Main.getMainStage());
            Main.setCanClose(false);
            stage.setOnCloseRequest(event1 -> {
                refresh();
                Main.setCanClose(true);
            });
            modifyPasswordController controller=loader.getController();
            controller.setUser(user);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void refresh(){
        Table.getItems().clear();
        userList.clear();
        loadData();
    }

    public void loadData(){
        users=HttpMethod.getAllusers();
        for(int i=0;i<users.size();i++){
            Map map=users.get(i).toMap();
            Button button=new Button("修改密码");
            button.setId(Integer.toString(i));
            button.setOnAction(event->{
                try{
                    Main.setCanClose(false);
                    editItem(users.get(Integer.parseInt(button.getId())));
                    refresh();
                }catch(Exception e){
                    e.printStackTrace();
                }
            });
            map.put("edit",button);
            userList.add(map);
        }
        Table.setItems(userList);
    }
    @FXML
    public void onRefresh(ActionEvent event){
        refresh();
    }
}
