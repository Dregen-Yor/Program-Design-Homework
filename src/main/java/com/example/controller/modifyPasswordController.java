package com.example.controller;

import java.io.ByteArrayInputStream;
import java.util.Base64;

import com.example.HttpMethod;
import com.example.Base.*;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class modifyPasswordController {

    @FXML
    public TextField checkCode;

    @FXML
    public ImageView Imageview;

    @FXML
    public Button newButton;

    @FXML
    public TextField newpassword;
    LineCaptcha lineCaptcha = null;

    private UserInfo user;

    @FXML
    public void onNewButton(ActionEvent event) {
        String password = this.newpassword.getText();
        String checkcode = this.checkCode.getText();
        if (password == null || password.length() == 0) {
            System.out.println("密码不能为空");
            MessageDialog.showDialog("密码不能为空");
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
        user.setPassword(password);
        HttpMethod.modifyPassword(user);
        Stage now = (Stage)newButton.getScene().getWindow();
        now.fireEvent(new WindowEvent(now, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void setUser(UserInfo user) {
        this.user = user;
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
