package com.example;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class InitStage {

    @FXML
    public TextField ac_Bookid;
    public TextField ac_Bookname;
    public PasswordField password;
    public TextField username;
    public Button Maction;
    public Button Saction;
    public Button search;
    searchStage searchstage;
    manageStage managestage;
    LoginStage Loginstage;
    public void SearchAction(ActionEvent event) {
        //主页图书信息搜索按钮
        try {
            searchstage = new searchStage();
            searchstage.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    public void Search(ActionEvent event) {
        //搜索按钮
    }

    @FXML
    public void Manageaction(ActionEvent event) {
        //主页图书信息管理按钮
        try{
            Loginstage=new LoginStage();
            Loginstage.start(new Stage());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public Button log;

    @FXML
    public void LogIn(ActionEvent event) {
        String user = username.getText();
        String Password = password.getText();
        try {
            Loginstage.Loginrequest(user,Password);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args){

    }
}
