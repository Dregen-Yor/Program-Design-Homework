package com.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import com.example.HttpMethod;
import com.example.Base.BookType;

public class editTypeController {

    @FXML
    public Button modifyButton;

    @FXML
    public TextField nameText;

    private BookType origin;

    @FXML
    void onModify(ActionEvent event) {
        String name = nameText.getText();
        if(name==""||name==null) {
            MessageDialog.showDialog("种类名不能为空");
            return;
        }
        origin.setName(name);
        try {
            if(module)
                HttpMethod.modifyType(origin);
            else
                HttpMethod.addBookType(origin);;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean module;
    public void setOrigin(BookType origin) {
        this.origin = origin;
        nameText.setText(origin.getName());
    }
    public void setModule(boolean module) {
        this.module = module;
    }
}
