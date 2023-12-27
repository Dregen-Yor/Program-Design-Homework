package com.example.controller;

import com.example.HttpMethod;
import com.example.Request.LoginRequest;
import javafx.event.ActionEvent;
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
    public void LogIn(ActionEvent event) {
        String user = username.getText();
        String Password = password.getText();
        // System.out.println(user+" "+Password);
        try {
            LoginRequest request =new LoginRequest(user,Password);
            String result= HttpMethod.login(request);
            if(result.equals("true")){
                Stage stage=new Stage();
                FXMLLoader loader =new FXMLLoader(getClass().getResource("manageStage.fxml"));
                Scene scene=new Scene(loader.load());
                stage.setTitle("管理图书信息");
                stage.setScene(scene);
                stage.show();
                Stage now=(Stage)log.getScene().getWindow();
                now.close();
            }
            else{
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialize(){
        username.setText("admin");
        password.setText("admin12345");
    }
}
