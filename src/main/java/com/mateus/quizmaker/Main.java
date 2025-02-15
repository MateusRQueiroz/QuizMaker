package com.mateus.quizmaker;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz_manager quiz_manager = new Quiz_manager();
        HashMap<String, Quiz> quizzes_HashMap = quiz_manager.getQuizzes_manager();
        boolean accessingQuiz = false;
        Quiz quiz = null;

        while(true) {
            System.out.println("""
                    Select an Option:
                    (A)ccess existing quiz
                    (V)iew quizzes
                    (C)reate new quiz
                    (R)emove quiz
                    (Q)uit
                    """);
            String user_choice = scanner.nextLine();
            switch (user_choice) {
                case "A" -> {
                    System.out.println();
                    System.out.println("Enter quiz name: ");
                    String quiz_name = scanner.nextLine();
                    quiz = quizzes_HashMap.get(quiz_name);
                    if (quiz == null) {
                        System.out.println("Quiz not found.");
                    } else {
                        System.out.println();
                        System.out.println("Quiz found.");
                        accessingQuiz = true;
                    }
                }
                case "V" -> {
                    System.out.println();
                    for (HashMap.Entry<String, Quiz> entry : quizzes_HashMap.entrySet()) {
                        System.out.println(entry.getKey());
                    }
                    System.out.println();
                }
                case "C" -> {
                    System.out.println();
                    System.out.println("Enter quiz name: ");
                    String new_quizName = scanner.nextLine();
                    quiz_manager.createQuiz(new_quizName);
                }
                case "R" -> {
                    System.out.println();
                    System.out.println("Enter quiz name: ");
                    String remove_quizName = scanner.nextLine();
                    quiz_manager.removeQuiz(remove_quizName);
                    System.out.println();
                }
                case "Q" -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
            if (accessingQuiz) {
                boolean back_toMenu = false;
                while (!back_toMenu) {
                    System.out.println();
                    System.out.println("""
                            Select an Option: 
                            (A)dd question
                            (R)emove question
                            (V)iew Quiz
                            (Q)uiz yourself
                            (B)ack to main menu
                            """);
                    String user_choice2 = scanner.nextLine();
                    switch (user_choice2) {
                        case "A" -> {
                            System.out.println();
                            System.out.println("Enter question: ");
                            String new_question = scanner.nextLine();
                            System.out.println("Enter answer: ");
                            String new_answer = scanner.nextLine();
                            if (quiz != null) {
                                quiz.addQuestion(new_question, new_answer);
                                System.out.println();
                                System.out.println("Question added.");
                                quiz_manager.saveToFile();
                            } else {
                                System.out.println();
                                System.out.println("No quiz selected.");
                            }
                            break;
                        }
                        case "R" -> {
                            System.out.println();
                            System.out.println("Enter question: ");
                            String toRemove_question = scanner.nextLine();
                            if (quiz != null) {
                                quiz.removeQuestion(toRemove_question);
                                System.out.println("Question removed.");
                                quiz_manager.saveToFile();
                            } else {
                                System.out.println("No quiz selected.");
                            }
                            break;
                        }
                        case "V" -> {
                            if (quiz != null) {
                                System.out.println(quiz.printQuiz());
                                System.out.println();
                            } else {
                                System.out.println("No quiz selected.");
                                System.out.println();
                            }
                            break;
                        }
                        case "Q" -> {
                            if (quiz != null) {
                                HashMap<String, String> quiz_hash = quiz.getQuiz();
                                float questions_total = quiz_hash.size();
                                float correct_answers = 0;
                                System.out.println("Starting quiz...");
                                for (HashMap.Entry<String, String> entry : quiz_hash.entrySet()) {
                                    System.out.println(entry.getKey() + " ");
                                    String answer = scanner.nextLine();
                                    if (answer.equals(entry.getValue())) {
                                        System.out.println();
                                        System.out.println("Correct!");
                                        System.out.println();
                                        correct_answers++;
                                    } else {
                                        System.out.println();
                                        System.out.println("Incorrect!");
                                        System.out.println();
                                        System.out.println("The correct answer was " + entry.getValue());
                                    }
                                }
                                float grade = (correct_answers / questions_total) * 100;
                                System.out.println();
                                System.out.println("Your grade is " + grade + "%");
                            } else {
                                System.out.println();
                                System.out.println("No quiz selected.");
                            }
                            break;
                        }
                        case "B" -> {
                            back_toMenu = true;
                            accessingQuiz = false;  // Reset flag when returning to main menu
                            System.out.println("Returning to main menu...\n");
                        }
                        default -> System.out.println("Invalid option. Try again.");
                    }
                }
            }
        }
    }
}
