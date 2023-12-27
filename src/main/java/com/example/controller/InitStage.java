package com.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
public class InitStage {
    @FXML
    public Button Maction;
    @FXML
    public Button Saction;
    @FXML
    public Button search;
    @FXML
    public Button search1;
    public void SearchAction(ActionEvent event) {
        //主页图书信息搜索按钮
        try {
            Stage stage=new Stage();
            FXMLLoader loader =new FXMLLoader(getClass().getResource("searchStage.fxml"));
            Scene scene=new Scene(loader.load());
            stage.setTitle("查找图书信息");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public ImageView tsxt;
    @FXML
    public void Manageaction(ActionEvent event) {
        //主页图书信息管理按钮
        try{
            Stage stage = new Stage();
            FXMLLoader loader =new FXMLLoader(getClass().getResource("loginStage.fxml"));
            Scene scene=new Scene(loader.load());
            stage.setTitle("登录");
            stage.setScene(scene);
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
