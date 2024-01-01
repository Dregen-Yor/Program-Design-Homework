package com.example.controller;

import com.example.Appstore;
import com.example.HttpMethod;
import com.example.Base.UserInfo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class passwordController {

    @FXML
    public PasswordField checkpassword;

    @FXML
    public PasswordField newpassword;

    @FXML
    public Button ok;

    @FXML
    public PasswordField oldpassword;

    @FXML
    public void OnOk(ActionEvent event) {
        //确认按钮
        String pass1=oldpassword.getText();
        String pass2=newpassword.getText();
        String pass3=checkpassword.getText();
        if(pass1.equals(Appstore.getPass())){
            if(pass2.equals(pass3)){
                Appstore.setPass(pass2);
                System.out.println("修改成功");
            }
            else{
                System.out.println("两次密码不一致");
            }
        }
        else{
            System.out.println("原密码错误");
        }
        Appstore.setPass(pass2);
        UserInfo user=new UserInfo(Appstore.getName(),Appstore.getPass(),Appstore.getRole(),Appstore.getId());
        HttpMethod.modifyPassword(user);
        Stage now = (Stage) ok.getScene().getWindow();
        now.close();
    }

}
