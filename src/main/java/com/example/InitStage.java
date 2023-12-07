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
        System.out.println("?");
    }

    @FXML
    public void Manageaction(ActionEvent event) {
        System.out.println("!");
    }
    public static void main(String[] args){

    }
}
