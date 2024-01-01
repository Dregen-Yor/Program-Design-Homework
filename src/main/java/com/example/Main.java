package com.example;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{

    public static Stage mainStage;

    public static boolean canClose=true;
    public void start(Stage stage)throws Exception{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("loginStage.fxml"));
        Scene scene=new Scene(loader.load());
        stage.setTitle("登录");
        stage.setScene(scene);
        
        stage.setOnCloseRequest(event -> {
            if(canClose) {
           }else {
               event.consume();
           }
        });
        stage.show();
        mainStage=stage;
    }
    public static void main(String[] args){
        launch(args);
    }

    public static void setMainStage(Stage mainStage) {
        Main.mainStage = mainStage;
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setCanClose(boolean canClose) {
        Main.canClose = canClose;
    }
}
