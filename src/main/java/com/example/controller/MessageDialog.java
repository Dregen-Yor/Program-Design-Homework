package com.example.controller;

import com.example.Main;
import com.example.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MessageDialog {
    public final static int CHOICE_OK = 1;
    public final static int CHOICE_CANCEL = 2;
    public final static int CHOICE_YES = 3;
    public final static int CHOICE_NO = 4;

    private  MessageController messageController= null;
    private static MessageDialog instance = new MessageDialog();

    private MessageDialog() {
        FXMLLoader fxmlLoader ;
        Scene scene = null;
        Stage stage;
        try {
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("controller/message-dialog.fxml"));
            scene = new Scene(fxmlLoader.load(), 300, 260);
            stage = new Stage();
            stage.initOwner(Main.getMainStage());
            stage.setAlwaysOnTop(true);
            stage.initModality(Modality.NONE);
            stage.setOnCloseRequest(e->{
                Main.setCanClose(true);
            });
            stage.setScene(scene);
            stage.setTitle("信息显示对话框");
            messageController = (MessageController) fxmlLoader.getController();
            messageController.setStage(stage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * showDialog 信息提示
     * @param msg  提示的信息
     */
    public static void showDialog(String msg) {
        if(instance == null)
            return;
        if(instance.messageController == null)
            return;
        instance.messageController.showDialog(msg);
        Main.setCanClose(false);
    }


}
