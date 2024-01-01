package com.example.controller;

import com.example.Appstore;
import com.example.HttpMethod;
import com.example.Request.LoginRequest;
import com.example.Main;

import com.example.Base.UserInfo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {
    public PasswordField password;
    public TextField username;
    @FXML
    public Button log;
    @FXML
    public Button reg;
    @FXML
    public void LogIn(ActionEvent event) {
        String user = username.getText();
        String Password = password.getText();
        try {
            LoginRequest request =new LoginRequest(user,Password);
            UserInfo result= HttpMethod.login(request);
            if(result!=null){
                Appstore.setRole(result);
                Stage stage=new Stage();
                FXMLLoader loader =new FXMLLoader(getClass().getResource("admin-frame.fxml"));
                Scene scene=new Scene(loader.load());
                stage.setTitle("管理图书信息");
                stage.setScene(scene);
                stage.show();
                stage.setMaximized(true);
                Stage now=(Stage)log.getScene().getWindow();
                now.close();
            }
            else{
                MessageDialog.showDialog("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onReg(ActionEvent event) {
        Stage stage=new Stage();
        FXMLLoader loader =new FXMLLoader(getClass().getResource("registerStage.fxml"));
        try{
            Scene scene=new Scene(loader.load());
            stage.setTitle("注册");
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(EventHandler->{
                Stage now= (Stage) reg.getScene().getWindow();
                Main.setMainStage(now);
            });
            Main.setMainStage(stage);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void initialize(){
        username.setText("admin");
        password.setText("admin123456");
    }
}
