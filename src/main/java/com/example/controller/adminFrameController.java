package com.example.controller;

import com.example.Main;
import com.example.MainApplication;
import com.example.Appstore;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class adminFrameController {
    class ChangePanelHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            changeContent(actionEvent);
        }
    }
    private Map<String,Tab> tabMap = new HashMap<String,Tab>();
    private Map<String,Scene> sceneMap = new HashMap<String,Scene>();
    private Map<String,ToolController> controlMap =new HashMap<String,ToolController>();
    @FXML
    public MenuBar menuBar;

    @FXML
    public TabPane tablePane;

    @FXML
    public TreeView<MyTreeNode> treeMenu;

    @FXML
    public Font x3;

    @FXML
    public Font x31;

    @FXML
    public Color x4;

    @FXML
    public Color x41;
    private ChangePanelHandler handler= null;
    public void addMenuItems(Menu parent, List<Map> mList) {
        String name, title;
        List sList;
        Map ms;
        Menu menu;
        MenuItem item;
        for ( Map m :mList) {
            sList = (List<Map>)m.get("sList");
            name = (String)m.get("name");
            title = (String)m.get("title");
            if(sList == null || sList.size()== 0) {
                item = new MenuItem();
                item.setId(name);
                item.setText(title);
                item.setOnAction(this::changeContent);
                parent.getItems().add(item);
            }else {
                menu = new Menu();
                menu.setText(title);
                addMenuItems(menu,sList);
                parent.getItems().add(menu);
            }
        }
    }

    /**
     * 页面加载对象创建完成初始话方法，页面中控件属性的设置，初始数据显示等初始操作都在这里完成，其他代码都事件处理方法里
     * 系统初始时为没个角色增加了框架已经实现好了基础管理的功能，采用代码显示添加的方法加入，加入完缺省的功能菜单后，通过
     * HttpRequestUtil.request("/api/base/getMenuList",new DataRequest())加载用菜单管理功能，维护的菜单
     * 项目开发过程中，同学可以扩该方法，增肌自己设计的功能菜单，也可以通过菜单管理程序添加菜单，框架自动加载菜单管理维护的菜单，
     * 是新功能扩展
     */
    public void addMenuItem(Menu menu, String name, String title){
        MenuItem item;
        item = new MenuItem();
        item.setText(title);
        item.setId(name);
        item.setOnAction(this::changeContent);
        menu.getItems().add(item);
    }
    public void initMenuBar(){
        Menu menu;
        MenuItem item;
        String role = Appstore.getRole();
        menu = new Menu("个人信息");
        item = new MenuItem();
        item.setText("修改密码");
        item.setId("controller/password-frame");
        item.setOnAction(e->changeContent("controller/password-frame","修改密码"));
        item.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                changeContent(actionEvent);
            }
        });
        menu.getItems().add(item);
        item = new MenuItem();
        item.setText("退出");
        item.setOnAction(this::onLogoutMenuClick);
        menu.getItems().add(item);
        menuBar.getMenus().add(menu);
        if("admin".equals(role)) {
            menu = new Menu("用户管理");
            addMenuItem(menu, "controller/user-frame", "用户列表");
            menuBar.getMenus().add(menu);

            menu =new Menu("图书管理");
            addMenuItem(menu,"controller/Book-frame","图书列表");
            addMenuItem(menu,"controller/BookType-frame","图书种类");
            menuBar.getMenus().add(menu);

            menu = new Menu("借阅管理");
            addMenuItem(menu,"controller/Borrow-frame","借阅记录");
            menuBar.getMenus().add(menu);
        }
        else{
            menu = new Menu("图书管理");
            addMenuItem(menu,"controller/Book-frame","图书查询");
            menuBar.getMenus().add(menu);

            menu = new Menu("借阅管理");
            addMenuItem(menu,"controller/Borrow-frame","借阅记录");
            menuBar.getMenus().add(menu);
        }

    }
    void addMenuItems( TreeItem<MyTreeNode> parent, List<Map> mList) {
        List sList;
        TreeItem<MyTreeNode> menu;
        for ( Map m :mList) {
            sList = (List<Map>)m.get("sList");
            menu = new TreeItem<>(new MyTreeNode(null,(String)m.get("name") ,(String)m.get("title"),0));
            parent.getChildren().add(menu);
            if(sList !=  null && sList.size()> 0) {
                addMenuItems(menu, sList);
            }
        }
    }
    public void initMenuTree(){
        String role= Appstore.getRole();
        MyTreeNode node =new MyTreeNode(null,null,"菜单",0);
        TreeItem<MyTreeNode> root = new TreeItem<>(node);
        TreeItem<MyTreeNode> menu;
        menu = new TreeItem<>(new MyTreeNode(null,null,"个人信息",0));
        menu.getChildren().add(new TreeItem<>(new MyTreeNode(null,"controller/password-frame","修改密码",1)));
        menu.getChildren().add(new TreeItem<>(new MyTreeNode(null,"logout","退出",1)));
        root.getChildren().add(menu);
        if(role.equals("admin")){
            menu = new TreeItem<>(new MyTreeNode(null,null,"用户管理",0));
            menu.getChildren().add(new TreeItem<>(new MyTreeNode(null,"controller/user-frame","用户列表",1)));
            root.getChildren().add(menu);

            menu = new TreeItem<>(new MyTreeNode(null,null,"图书管理",0));
            menu.getChildren().add(new TreeItem<>(new MyTreeNode(null,"controller/Book-frame","图书列表",1)));
            menu.getChildren().add(new TreeItem<>(new MyTreeNode(null,"controller/BookType-frame","图书种类",1)));
            root.getChildren().add(menu);

            menu = new TreeItem<>(new MyTreeNode(null,null,"借阅管理",0));
            menu.getChildren().add(new TreeItem<>(new MyTreeNode(null,"controller/Borrow-frame","借阅记录",1)));
            root.getChildren().add(menu);
        }
        else{
            menu = new TreeItem<>(new MyTreeNode(null,null,"图书管理",0));
            menu.getChildren().add(new TreeItem<>(new MyTreeNode(null,"controller/Book-frame","图书查询",1)));
            root.getChildren().add(menu);

            menu = new TreeItem<>(new MyTreeNode(null,null,"借阅管理",0));
            menu.getChildren().add(new TreeItem<>(new MyTreeNode(null,"controller/Borrow-frame","借阅记录",1)));
            root.getChildren().add(menu);
        }
        treeMenu.setRoot(root);
        treeMenu.setShowRoot(false);
        treeMenu.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Node node = mouseEvent.getPickResult().getIntersectedNode();
                TreeItem<MyTreeNode> item = treeMenu.getSelectionModel().getSelectedItem();
                if(item == null)
                    return;
                MyTreeNode menu = item.getValue();
                String name = menu.getValue();
                if(name == null||name.length()==0)
                    return;
                if(name.equals("logout")) {
                    logout();
                    return;
                }
                changeContent(name,menu.getLabel());
            }
        });
    }
    @FXML
    public void initialize() {
        initMenuBar();
        initMenuTree();
        tablePane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        tablePane.setStyle("-fx-background-repeat: no-repeat; -fx-background-size: cover;");
    }
    public  void changeContent(ActionEvent ae) {
        Object obj = ae.getSource();
        String name= null, title= null;
        if(obj instanceof MenuItem) {
            MenuItem item = (MenuItem)obj;
            name = item.getId();
            title = item.getText();
        }
        if(name == null)
            return;
        changeContent(name,title);
    }
    /**
     * 点击菜单栏中的菜单 执行changeContent 在主框架工作区增加和显示一个工作面板
     * @param name  菜单名 name.fxml 对应面板的配置文件
     * @param title 菜单标题 工作区中的TablePane的标题
     */

    public  void changeContent(String name, String title) {
        if(name == null || name.length() == 0)
            return;
        Tab tab = tabMap.get(name);
        Scene scene;
        Object c;
        if(tab == null) {
            scene = sceneMap.get(name);
            if(scene == null) {
                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(name + ".fxml"));
                try {
                    scene = new Scene(fxmlLoader.load(), 1024, 768);
                    sceneMap.put(name, scene);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                c = fxmlLoader.getController();
                if(c instanceof ToolController) {
                    controlMap.put(name,(ToolController)c);
                }
            }
            tab = new Tab(title);
            tab.setId(name);
            tab.setOnSelectionChanged(this::tabSelectedChanged);
            tab.setOnClosed(this::tabOnClosed);
            tab.setContent(scene.getRoot());
            tablePane.getTabs().add(tab);
            tabMap.put(name, tab);
        }
        tablePane.getSelectionModel().select(tab);
    }
    public void tabSelectedChanged(Event e) {
        Tab tab = (Tab)e.getSource();
        String name = tab.getId();
        ToolController c = controlMap.get(name);
        if(c != null)
            c.doRefresh();
//        Node node =tab.getContent();
//        Scene scene = node.getScene();

    }
    /**
     * 点击TablePane 标签页 的关闭图标 执行tabOnClosed方法
     * @param e
     */

    public void tabOnClosed(Event e) {
        Tab tab = (Tab)e.getSource();
        String name = tab.getId();
        tablePane.getTabs().remove(tab);
        tabMap.remove(name);
    }
    /**
     * 点击菜单栏中的“退出”菜单，执行onLogoutMenuClick方法 加载登录页面，切换回登录界面
     * @param event
     */

    public void onLogoutMenuClick(ActionEvent event){
        logout();
    }
    public void logout(){
        try {
            Stage now =Main.getMainStage();
            now.fireEvent(new WindowEvent(now, WindowEvent.WINDOW_CLOSE_REQUEST));
            Stage stage = new Stage();
            Scene scene = new Scene(FXMLLoader.load(Main.class.getResource("loginStage.fxml")));
            stage.setTitle("登录");
            stage.setScene(scene);
            Main.setMainStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
