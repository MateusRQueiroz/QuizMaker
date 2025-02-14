package com.mateus.quizmaker;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;


public class Quiz_manager {
    HashMap<String, HashMap<String,String>> quizzes_manager = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    Gson gson = new Gson();
    public Quiz_manager() { 
        loadFromFile();
    }

    public void createQuiz(String quiz_name) {
        Quiz quiz = new Quiz(quiz_name);
        while(true) {
            System.out.println("Enter a question or (Q)uit: ");
            String user_input = scanner.nextLine();
            if (!user_input.equals("Q")) {
                System.out.println("Enter the desired answer: ");
                String answer_input = scanner.nextLine();
                quiz.addQuestion(user_input, answer_input);
            } else {
                break;
            }
        scanner.close();
        }
        quizzes_manager.put(quiz_name, quiz.getQuiz());
        saveToFile();
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("src\\main\\java\\com\\quizzes.json")) {
            gson.toJson(quizzes_manager, writer);
        } catch (IOException e) {
        }
    }

    public final void loadFromFile() {
        try (FileReader reader = new FileReader("src\\main\\java\\com\\quizzes.json")) {
            gson.fromJson(reader, quizzes_manager.getClass());
        } catch (IOException e) {
        }
        
    }

    public HashMap<String, HashMap<String, String>> getQuizzes_manager() { return quizzes_manager; }

}