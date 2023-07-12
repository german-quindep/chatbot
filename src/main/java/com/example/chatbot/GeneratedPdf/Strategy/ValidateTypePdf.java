package com.example.chatbot.GeneratedPdf.Strategy;

public enum ValidateTypePdf {
    CON_INGRESOS("CON_INGRESOS", "con-ingresos"), SIN_INGRESOS("SIN_INGRESOS", "sin-ingresos"),
    PASANTES("PASANTES", "pasantes"), CON_COMISION("CON_COMISION", "con-comision");

    private final String messageType;
    private final String typePdf;

    private ValidateTypePdf(String typePdf, String messageType) {
        this.typePdf = typePdf;
        this.messageType = messageType;
    }

    public boolean validate(String input) {
        return messageType.equals(input);
    }

    public String getmessageType() {
        return typePdf;
    }
}
