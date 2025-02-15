package com.mateus.quizmaker;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz_manager quiz_manager = new  Quiz_manager();
        while(true) {
            System.out.println("""
                    Select an Option:
                    (A)ccess existing quiz
                    (C)reate new quiz
                    (Q)uit
                    """);
            String user_choice = scanner.nextLine();
            switch (user_choice) {
                case "A":
                    System.out.println("Enter quiz name: ");
                    String quiz_name = scanner.nextLine();
                    HashMap<String, Quiz> quizzes_HashMap = quiz_manager.getQuizzes_manager();
                    Quiz quiz = quizzes_HashMap.get(quiz_name);
                    if (!quizzes_HashMap.containsKey(quiz_name)) {
                        System.out.println("Quiz not found.");
                    } else {
                        System.out.println("Quiz found.");
                        System.out.println("""
                                Select an Option: 
                                (A)dd question
                                (R)emove question
                                (V)iew Quizz
                                (Q)uiz yourself
                                """);
                        String user_choice2 = scanner.nextLine();
                        switch (user_choice2) {
                            case "A" -> {
                                System.out.println("Enter question: ");
                                String new_question = scanner.nextLine();
                                System.out.println("Enter answer: ");
                                String new_answer = scanner.nextLine();
                                quiz.addQuestion(new_question, new_answer);
                                System.out.println("Question added.");
                                quiz_manager.saveToFile();
                            }
                            case "R" -> {
                                System.out.println("Enter question: ");
                                String toRemove_question = scanner.nextLine();
                                quiz.removeQuestion(toRemove_question);
                                System.out.println("Question removed.");
                                quiz_manager.saveToFile();
                            }
                            case "V" -> {
                                System.out.println((quiz.getQuiz()));
                            }
                            case "Q" -> {
                                // Add code for quizzing yourself
                            }
                        }
                }


                case "C":
                    break;
                case "Q": 
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

