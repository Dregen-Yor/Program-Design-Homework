package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class LoginStage extends Application{
    public void start(Stage stage)throws Exception{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("loginStage.fxml"));
        Scene scene=new Scene(loader.load());
        stage.setTitle("登录");
        stage.setScene(scene);
        stage.show();
    }
    public void Loginrequest(String user,String Password){
        try{
            Main.connect.sendMessage("logRequest");     //发送登录请求
            Main.connect.sendMessage(user);
            Main.connect.sendMessage(Password);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public boolean getresult()throws IOException{
        if(Main.connect.getMessage().equals("true")){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        launch(args);
    }
}
