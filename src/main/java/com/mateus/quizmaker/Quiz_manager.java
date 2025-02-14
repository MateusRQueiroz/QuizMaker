package com.mateus.quizmaker;

import java.util.HashMap;
import java.util.Scanner;

public class Quiz_manager {
    HashMap<String, HashMap<String,String>> quizzes_manager = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    public Quiz_manager() { }

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
        quizzes_manager.put(quiz_name, quiz.getQuiz());
        saveToFile();
    }
    public void saveToFile() {
        
    }

    public HashMap loadFromFile() {
        return null;
    }
}