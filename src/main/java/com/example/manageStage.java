package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class manageStage extends Application{
    public void start(Stage stage)throws Exception{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("manageStage.fxml"));
        Scene scene=new Scene(loader.load());
        stage.setTitle("管理图书信息");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
