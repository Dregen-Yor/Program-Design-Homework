module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires hutool.all;
    requires java.desktop;

    opens com.example to javafx.base,com.google.gson;
    opens com.example.Request to com.google.gson;
    opens com.example.controller to javafx.fxml,com.google.gson,javafx.base;
    opens com.example.Base to com.google.gson;
//    opens com.teach.bookcode to javafx.fxml;
//    opens com.teach.bookcode.javafx.appendixh to javafx.fxml;
//    exports com.teach.bookcode;
    exports com.example;
    exports com.example.controller;
    // opens com.example.controller to com.google.gson, javafx.base;

}