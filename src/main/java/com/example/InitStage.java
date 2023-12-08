package com.example;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class InitStage {

    @FXML
    public Button Maction;

    @FXML
    public Button Saction;

    @FXML
    public void SearchAction(ActionEvent event) {
        //主页图书信息搜索按钮
        try {
            searchStage searchstage = new searchStage();
            searchstage.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button search;

    @FXML
    public void Search(ActionEvent event) {
        //搜索按钮
    }

    @FXML
    public void Manageaction(ActionEvent event) {
        //主页图书信息管理按钮
        try{
            LoginStage stage=new LoginStage();
            stage.start(new Stage());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public Button log;

    @FXML
    public void LogIn(ActionEvent event) {
        //登录页面登录按钮
    }

    @FXML
    public Button connectOK;

    @FXML
    public void ConnectOK(ActionEvent event) {
        //等待连接页面连接成功按钮
        Stage now =(Stage)connectOK.getScene().getWindow();
        now.close();
        Stage stage=new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InitStage.fxml"));
            Scene scene=new Scene(loader.load());
            stage.setTitle("图书信息管理系统");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            
        }
        
    }
    public static void main(String[] args){

    }
}
