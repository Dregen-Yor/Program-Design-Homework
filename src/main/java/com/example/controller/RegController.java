package com.example.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.example.HttpMethod;
import com.example.Request.LoginRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Base64;

public class RegController {

    @FXML
    public ImageView Imageview;

    @FXML
    public TextField checkcode;

    @FXML
    public PasswordField password;

    @FXML
    public PasswordField password2;

    @FXML
    public Button reg;

    @FXML
    public TextField username;
    LineCaptcha lineCaptcha = null;
    @FXML
    public void onReg(ActionEvent event) {
        String username = this.username.getText();
        String password = this.password.getText();
        String password2 = this.password2.getText();
        String checkcode = this.checkcode.getText();
        if (username == null || username.length() == 0) {
            System.out.println("用户名不能为空");
            MessageDialog.showDialog("用户名不能为空");
            refresh();
            return;
        }
        if (password == null || password.length() == 0) {
            System.out.println("密码不能为空");
            MessageDialog.showDialog("密码不能为空");
            refresh();
            return;
        }
        if (!password.equals(password2)) {
            System.out.println("两次密码不一致");
            MessageDialog.showDialog("两次密码不一致");
            refresh();
            return;
        }
        if (checkcode == null || checkcode.length() == 0) {
            System.out.println("验证码不能为空");
            MessageDialog.showDialog("验证码不能为空");
            refresh();
            return;
        }
        if(!checkcode.equals(lineCaptcha.getCode())) {
            System.out.println("验证码错误");
            MessageDialog.showDialog("验证码错误");
            refresh();
            return;
        }
        HttpMethod.register(new LoginRequest(username, password));
        MessageDialog.showDialog("注册成功，请登录");
        Stage now =(Stage)reg.getScene().getWindow();
        now.close();
    }

    @FXML
    public void initialize() {
        refresh();
    }
    public void refresh(){
        lineCaptcha = CaptchaUtil.createLineCaptcha(152, 76);
//        String base64String = HttpMethod.getCap();
        String base64String = lineCaptcha.getImageBase64();
        byte[] imageData = Base64.getDecoder().decode(base64String);
        Image image = new Image(new ByteArrayInputStream(imageData));
        Imageview.setImage(image);
    }
}
