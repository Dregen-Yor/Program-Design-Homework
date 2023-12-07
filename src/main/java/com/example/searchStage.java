package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class searchStage extends Application{
    public void start(Stage stage)throws Exception{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("searchStage.fxml"));
        Scene scene=new Scene(loader.load());
        stage.setTitle("查找图书信息");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        // Application.launch(InitStage.class);

        launch(args);
    }
}
