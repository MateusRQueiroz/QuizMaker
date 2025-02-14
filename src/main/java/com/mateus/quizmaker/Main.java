package com.mateus.quizmaker;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        
        // Example usage of Gson
        String json = gson.toJson("33");
        System.out.println(json);
    }
}

