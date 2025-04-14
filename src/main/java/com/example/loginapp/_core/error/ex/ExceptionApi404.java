package com.example.loginapp._core.error.ex;

// Ajax는 이걸 터트려야 함!
public class ExceptionApi404 extends RuntimeException {
    public ExceptionApi404(String message) {
        super(message);
    }
}
