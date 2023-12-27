package com.example.controller;

import com.example.Request.BookRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class searchController {
    public TextField ac_Bookid;
    public TextField ac_Bookname;
    @FXML
    public void SearchName(ActionEvent event) {
        //搜索按钮
        String name=ac_Bookname.getText();

        try{
            FXMLLoader loader =new FXMLLoader(getClass().getResource("SearchResult.fxml"));
            Stage stage=new Stage();
            Scene scene=new Scene(loader.load());
            stage.setTitle("查找结果");
            stage.setScene(scene);
            stage.show();
            BookRequest bookRequest=new BookRequest("name",name);
            ResultController controller=loader.getController();
            controller.setBookRequest(bookRequest);
            controller.loadData();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    public void SearchId(ActionEvent event) {
        //搜索按钮id
        String id=ac_Bookid.getText();
        try{
            FXMLLoader loader =new FXMLLoader(getClass().getResource("SearchResult.fxml"));
            Stage stage=new Stage();
            Scene scene=new Scene(loader.load());
            stage.setTitle("查找结果");
            stage.setScene(scene);
            stage.show();
            BookRequest bookRequest=new BookRequest("id",id);
            ResultController controller=loader.getController();
            controller.setBookRequest(bookRequest);
            controller.loadData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
