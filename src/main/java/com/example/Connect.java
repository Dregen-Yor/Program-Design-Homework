package com.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.net.*;
import java.io.*;
public class Connect{
    private Socket socket;
    private InputStream inFromserver;
    private OutputStream outToserver;
    private DataInputStream in;
    private DataOutputStream out;
    private ObjectOutputStream outObject;
    private ObjectInputStream inObject;
    public void connect(){
        Stage wait;
        FXMLLoader loader;
        try{
            wait=new Stage();
            loader=new FXMLLoader(getClass().getResource("WaitStage.fxml"));
            wait.setTitle("等待连接");
            wait.initStyle(StageStyle.UNDECORATED);
            wait.setScene(new Scene(loader.load()));
            wait.show();
            while(true){
                try{
                    socket=new Socket("127.0.0.1",1503);
                    break;
                }catch(Exception e){
                    // System.out.println("连接失败");
                }
            }
            wait.close();
            inFromserver =socket.getInputStream();
            in=new DataInputStream(inFromserver);
            outToserver=socket.getOutputStream();
            out=new DataOutputStream(outToserver);
            outObject=new ObjectOutputStream(outToserver);
            inObject=new ObjectInputStream(inFromserver);
            loader=new FXMLLoader(getClass().getResource("connectsuccess.fxml"));
            Stage success=new Stage();
            success.setTitle("连接成功");
            success.setScene(new Scene(loader.load()));
            success.show();//创建登录成功页面
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Connect(){
        connect();//方法构造初始化
    }
    public void sendMessage(String message)throws IOException{
        out.writeUTF(message);
    }
    public String getMessage()throws IOException{
        String res=in.readUTF();
        System.out.println(res);
        return res;
    }
    public void sendObject(Object message)throws IOException{
        outObject.writeObject(message);
    }
    public Object getObject()throws IOException,ClassNotFoundException{
        Object res=inObject.readObject();
        return res;
    }
}
