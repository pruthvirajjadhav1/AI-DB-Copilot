package com.pruthvi.sqlAi.exception;

public class EmptyQuestionException extends RuntimeException {
    public EmptyQuestionException() {
        super("Question cannot be empty");
    }
}
