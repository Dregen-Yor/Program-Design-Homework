package com.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.net.*;
public class Connect{
    public Socket socket;
    public void connect(){
        try{
            Stage wait=new Stage();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("WaitStage.fxml"));
            wait.setTitle("等待连接");
            wait.initStyle(StageStyle.UNDECORATED);
            wait.setScene(new Scene(loader.load()));
            wait.show();
            socket=new Socket("127.0.0.1",1503);
            while(!socket.isConnected());
            wait.close();
            loader=new FXMLLoader(getClass().getResource("connectsuccess.fxml"));
            Stage success=new Stage();
            success.setTitle("连接成功");
            success.setScene(new Scene(loader.load()));
            success.show();
        }
        catch(Exception e){

        }
    }
}
