package com.mateus.quizmaker;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class Quiz_manager {
    HashMap<String, Quiz> quizzes_manager = new HashMap<>();
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
        }
        quizzes_manager.put(quiz_name, quiz);
        saveToFile();
    }

    public void removeQuiz(String quiz_name) {
        quizzes_manager.remove(quiz_name);
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
            Type quizMapType = new TypeToken<HashMap<String, Quiz>>() {}.getType();
            quizzes_manager = gson.fromJson(reader, quizMapType);
        } catch (IOException e) {
        }
        
    }

    public HashMap<String, Quiz> getQuizzes_manager() {
        return quizzes_manager;
    }
}