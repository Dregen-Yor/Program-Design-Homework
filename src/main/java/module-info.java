module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example to javafx.base,com.google.gson;
    opens com.example.Request to com.google.gson;
//    opens com.teach.bookcode to javafx.fxml;
//    opens com.teach.bookcode.javafx.appendixh to javafx.fxml;
//    exports com.teach.bookcode;
    exports com.example;
    exports com.example.controller;
    opens com.example.controller to com.google.gson, javafx.base;

}