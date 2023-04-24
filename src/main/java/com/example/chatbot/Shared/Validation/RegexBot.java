package com.example.chatbot.Shared.Validation;

public enum RegexBot {
    NUMERO_10_DIGITOS("^\\d{10}$", "CEDULA"),
    NUMERO_4_DIGITOS("^\\d{4}$", "OTP"),
    FECHA("^\\d{4}-\\d{2}-\\d{2}$", "FECHA");

    private final String regex;
    private final String messageType;

    RegexBot(String regex, String messageType) {
        this.regex = regex;
        this.messageType = messageType;
    }

    public boolean isValid(String input) {
        return input.matches(regex);
    }

    public String getmessageType() {
        return messageType;
    }
}
