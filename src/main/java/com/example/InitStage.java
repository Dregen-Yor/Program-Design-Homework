package com.example;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class InitStage {

    @FXML
    public TextField ac_Bookid;
    public TextField ac_Bookname;
    public PasswordField password;
    public TextField username;
    public Button Maction;
    public Button Saction;
    public Button search;
    public Button search1;
    searchStage searchstage=new searchStage();
    manageStage managestage=new manageStage();
    LoginStage Loginstage=new LoginStage();
    public void SearchAction(ActionEvent event) {
        //主页图书信息搜索按钮
        try {
            // searchstage = new searchStage();
            searchstage.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public ImageView tsxt;

    @FXML
    public void SearchName(ActionEvent event) {
        //搜索按钮
        String name=ac_Bookname.getText();
        try{
            searchstage.searchname(name);

        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    @FXML
    public void SearchId(ActionEvent event) {
        //搜索按钮id
        String id=ac_Bookid.getText();
        searchstage.searchId(id);
    }

    @FXML
    public void Manageaction(ActionEvent event) {
        //主页图书信息管理按钮
        try{
            Loginstage.start(new Stage());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public Button log;

    @FXML
    public void LogIn(ActionEvent event) {
        String user = username.getText();
        String Password = password.getText();
        System.out.println(user+" "+Password);
        try {
            Loginstage.Loginrequest(user,Password);
            if(Loginstage.getresult()){
                managestage = new manageStage();
                managestage.start(new Stage());
                Stage now=(Stage)log.getScene().getWindow();
                now.close();
            }
            else{
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button connectOK;

    @FXML
    public void ConnectOK(ActionEvent event) {
        //等待连接页面连接成功按钮
        Stage now =(Stage)connectOK.getScene().getWindow();
        now.close();
        Stage stage=new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InitStage.fxml"));
            // tsxt.setImage(new Image(getClass().getResource("gull.jpg").toExternalForm()));
            Scene scene=new Scene(loader.load());
            stage.setTitle("图书信息管理系统");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args){

    }
}
