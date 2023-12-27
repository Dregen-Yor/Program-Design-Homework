package com.example;
import java.lang.reflect.Type;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import com.example.Request.BookRequest;
import com.example.Request.LoginRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.http.HttpRequest.BodyPublishers; // Import the missing class
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class HttpMethod {
    private static Gson gson = new Gson();
    private static Type type = new TypeToken<ArrayList<Book>>() {}.getType();
    private static HttpClient client = HttpClient.newHttpClient();
    public static String serverUrl = "http://localhost:1503";
    public static String login(LoginRequest loginRequest){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/login"))
                .POST(BodyPublishers.ofString(gson.toJson(loginRequest)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        System.out.println(gson.toJson(loginRequest));
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return gson.fromJson(response.body(), String.class);
        }catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

    }
    public static ArrayList<Book> getBook(BookRequest bookRequest){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/getbook"))
                .POST(BodyPublishers.ofString(gson.toJson(bookRequest))) // Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ArrayList<Book> books = gson.fromJson(response.body(), type);
            return books;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void addBook(Book book){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/addbook"))
                .POST(BodyPublishers.ofString(gson.toJson(book))) // Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteBook(Book book){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/delete"))
                .POST(BodyPublishers.ofString(gson.toJson(book))) // Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Book> getAll(String arg){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/getall"))
                .POST(BodyPublishers.ofString(gson.toJson(arg)))
                .headers("Content-Type", "application/json")// Use the correct method
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ArrayList<Book> books = gson.fromJson(response.body(), type);
            return books;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
