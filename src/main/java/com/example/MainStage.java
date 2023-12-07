package com.example;
import java.io.IOException;

//使用JavaFX搭建主窗口
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class MainStage extends Application{
    public void start(Stage stage)throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InitStage.fxml"));
        Scene scene=new Scene(loader.load());
        stage.setTitle("图书信息管理系统");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {

        launch(args);
    }
    // @Override
    // public void start(Stage arg0) throws Exception {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'start'");
    // }
}
