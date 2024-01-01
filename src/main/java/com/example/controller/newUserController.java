package com.example.controller;

import com.example.HttpMethod;
import com.example.Request.LoginRequest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class newUserController {

    @FXML
    public Button newuser;

    @FXML
    public TextField passWord;

    @FXML
    public TextField userName;

    @FXML
    void onNewuser(ActionEvent event) {
        String username = this.userName.getText();
        String password = this.passWord.getText();

        if (username == null || username.length() == 0) {
            System.out.println("用户名不能为空");
            MessageDialog.showDialog("用户名不能为空");
            return;
        }
        if (password == null || password.length() == 0) {
            System.out.println("密码不能为空");
            MessageDialog.showDialog("密码不能为空");
            return;
        }
        HttpMethod.register(new LoginRequest(username, password));
        Stage now = (Stage) newuser.getScene().getWindow();
        now.close();
    }
}
