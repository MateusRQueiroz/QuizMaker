package com.mateus.quizmaker;


public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String get_question() { return question; }
    public String get_answer() { return answer; }
    
}
