package com.example;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{
    public static Connect connect;//方便全局访问
    public void start(Stage stage)throws Exception{
        connect=new Connect();
    }
    public static void main(String[] args){
        launch(args);//不这样写会报错（）
    }
}
