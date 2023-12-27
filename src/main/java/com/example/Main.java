package com.example;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{
    public void start(Stage stage)throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("InitStage.fxml"));
        Scene scene=new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("图书管理系统");
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
