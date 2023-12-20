package com.example;

import java.io.IOException;
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
    public void searchname(String name){
        try{
            Main.connect.sendMessage("serchacrName");
            Main.connect.sendMessage(name);
            FXMLLoader loader =new FXMLLoader(getClass().getResource("SearchResult.fxml"));
            Stage stage=new Stage();
            Scene scene=new Scene(loader.load());
            stage.setTitle("查找结果");
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void searchId(String id){
        try{
            Main.connect.sendMessage("serchacrID");
            Main.connect.sendMessage(id);
            FXMLLoader loader =new FXMLLoader(getClass().getResource("SearchResult.fxml"));
            Stage stage=new Stage();
            Scene scene=new Scene(loader.load());
            stage.setTitle("查找结果");
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // Application.launch(InitStage.class);

        launch(args);
    }
}
