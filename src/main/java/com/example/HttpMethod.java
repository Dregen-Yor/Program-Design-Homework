package com.example;
import java.lang.reflect.Type;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import com.example.Request.BookRequest;
import com.example.Request.LoginRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.example.Base.*;
import java.net.http.HttpRequest.BodyPublishers; // Import the missing class
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HttpMethod {
    private static Gson gson = new Gson();
    private static Type typeBook = new TypeToken<ArrayList<Book>>() {}.getType();
    private static Type typeUser = new TypeToken<ArrayList<UserInfo>>() {}.getType();
    private static Type typeHistory = new TypeToken<ArrayList<History>>() {}.getType();
    private static Type typeType = new TypeToken<ArrayList<com.example.Base.BookType>>() {}.getType();
    private static HttpClient client = HttpClient.newHttpClient();
    // public static String serverUrl = "http://202.194.14.120:9090";
    public static String serverUrl = "http://127.0.0.1:1503";
    public static UserInfo login(LoginRequest loginRequest){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/login"))
                .POST(BodyPublishers.ofString(gson.toJson(loginRequest)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        // System.out.println(gson.toJson(loginRequest));
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return gson.fromJson(response.body(), UserInfo.class);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public static Book getBook(int id){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/getbook"))
                .POST(BodyPublishers.ofString(gson.toJson(id))) // Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Book books = gson.fromJson(response.body(), Book.class);
            return books;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<History> getAllHistory(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/getallHistory"))
                .GET()
                .headers("Content-Type", "application/json")// Use the correct method
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ArrayList<History> historys = gson.fromJson(response.body(), typeHistory);
            return historys;
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
                .uri(URI.create(serverUrl + "/auth/deletebook"))
                .POST(BodyPublishers.ofString(gson.toJson(book))) // Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            System.out.println(gson.toJson(book));
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Book> getAllBook(String arg){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/getallBook"))
                .GET()
                .headers("Content-Type", "application/json")// Use the correct method
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ArrayList<Book> books = gson.fromJson(response.body(), typeBook);
            return books;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String getCap() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/Get/Captcha"))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<com.example.Base.BookType> getallType(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/getallType"))
                .GET()
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ArrayList<com.example.Base.BookType> types = gson.fromJson(response.body(), typeType);
            return types;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addBookType(BookType booktype){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/addType"))
                .POST(BodyPublishers.ofString(gson.toJson(booktype)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String register(LoginRequest loginRequest){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/register"))
                .POST(BodyPublishers.ofString(gson.toJson(loginRequest)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
//        System.out.println(gson.toJson(loginRequest));
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // System.out.println(response.body());
            return gson.fromJson(response.body(), String.class);
        }catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

    }

    public static void modifyPassword(UserInfo user){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/modifyPassword"))
                .POST(BodyPublishers.ofString(gson.toJson(user)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void modifyBook(Book book){
         HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/modifybook"))
                .POST(BodyPublishers.ofString(gson.toJson(book)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addHistory(History history){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/addhistory"))
                .POST(BodyPublishers.ofString(gson.toJson(history)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserInfo searchUserInfo(int userId){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/searchUserInfo"))
                .POST(BodyPublishers.ofString(gson.toJson(userId)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return gson.fromJson(response.body(), UserInfo.class);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BookType searchType(int typeId){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/searchType"))
                .POST(BodyPublishers.ofString(gson.toJson(typeId)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), BookType.class);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void modifyType(BookType bookType){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/modifyType"))
                .POST(BodyPublishers.ofString(gson.toJson(bookType)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
    }

    public static ArrayList<UserInfo> getAllusers(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/getallUser"))
                .GET()
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ArrayList<UserInfo> users = gson.fromJson(response.body(), typeUser);
            return users;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static  boolean historyExist(Book book){
        Map map=new HashMap();
        map.put("Bookid",book.getBookid());
        map.put("userid",Appstore.getId());
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/historyExist"))
                .POST(BodyPublishers.ofString(gson.toJson(map)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Boolean.class);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        
    }
    public static  History findhistory(Book book){
        Map map=new HashMap();
        map.put("Bookid",book.getBookid());
        map.put("userid",Appstore.getId());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/findhistory"))
                .POST(BodyPublishers.ofString(gson.toJson(map)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), History.class);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void modifyHistory(History history){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverUrl + "/auth/modifyhistory"))
                .POST(BodyPublishers.ofString(gson.toJson(history)))// Use the correct method
                .headers("Content-Type", "application/json")
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
