package com.example;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class InitStage extends Application{
    @FXML
    private Button manageAction;

    @FXML
    private Button searchAction;

    @FXML
    void ManageAction(ActionEvent event) {

    }

    @FXML
    void SearchAction(ActionEvent event) {

    }
    public void start(Stage stage)throws IOException{
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("InitStage.fxml"));
        // Scene scene=new Scene(loader.load());
        stage.setTitle("图书信息管理系统");
        // stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

