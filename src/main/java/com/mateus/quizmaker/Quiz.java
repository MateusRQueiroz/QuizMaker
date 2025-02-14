package com.mateus.quizmaker;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Quiz {
    private ArrayList<Question> questions_ArrayList = new ArrayList<>();
    private final String file_name = "quizzes.json";
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, String> quiz = new HashMap<String, String>();
    Gson gson = new Gson();

    public Quiz() {
        loadFromFile();
    }

    public void add_Quiz(String quiz_name) {
        while (true) {
            System.out.println("Enter a question or 'N' to end: ");
            String question_input = scanner.nextLine();
            if (question_input.equals("N")) {
                break;
            }
            else {
                System.out.println("Enter the answer: ");
                String answer_input = scanner.nextLine();
                Question question = new Question(question_input, answer_input);
                quiz.put(question_input, answer_input);
            }
        }
        saveToFile();
    }

    public void saveToFile() {
        String json = gson.toJson(quiz);
    }

    public void loadFromFile() {

    }
}