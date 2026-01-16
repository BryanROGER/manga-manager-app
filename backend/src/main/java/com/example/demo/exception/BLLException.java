package com.example.demo.exception;

import lombok.Getter;

@Getter
public class BLLException extends RuntimeException{

    private final String errorCode;

    public BLLException(String errorCode, String message, Object... args) {
        super(formatMessage(message, args));
        this.errorCode = errorCode;
    }

    private static String formatMessage(String message, Object... args) {
        if (args == null || args.length == 0) return message;

        String formatted = message;
        for (Object arg : args) {
            formatted = formatted.replaceFirst("\\{}", arg.toString());
        }
        return formatted;
    }
}
