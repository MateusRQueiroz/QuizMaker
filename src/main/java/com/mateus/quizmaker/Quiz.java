package com.mateus.quizmaker;

import java.util.HashMap;

public class Quiz {
    private final HashMap<String, String> quiz = new HashMap<>();
    private final String quiz_name;

    public Quiz(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public void addQuestion(String question, String answer) {
        quiz.put(question, answer);
    }

    public void removeQuestion(String question) {
        quiz.remove(question);
    }

    public String getName() {
        return quiz_name;
    }

    public HashMap<String, String> getQuiz() {
        return new HashMap<>(quiz);
    }

    public String printQuiz() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<String, String> entry : quiz.entrySet()) {
            sb.append("Question: ").append(entry.getKey()).append("\n");
            sb.append("Answer: ").append(entry.getValue()).append("\n\n");
        }
        return sb.toString();
    }
}
