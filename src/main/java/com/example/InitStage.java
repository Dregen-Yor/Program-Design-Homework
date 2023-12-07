package com.example;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class InitStage {

    @FXML
    public Button Maction;

    @FXML
    public Button Saction;

    @FXML
    public void SearchAction(ActionEvent event) {
        try {
            searchStage searchstage = new searchStage();
            searchstage.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button search;

    @FXML
    public void Search(ActionEvent event) {

    }

    @FXML
    public void Manageaction(ActionEvent event) {
        Application.launch(manageStage.class);
    }
    public static void main(String[] args){

    }
}
