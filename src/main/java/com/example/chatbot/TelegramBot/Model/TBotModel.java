package com.example.chatbot.TelegramBot.Model;

public class TBotModel {
    private String tipo_mensaje;
    
    public TBotModel() {
    }

    public TBotModel(String tipo_mensaje) {
        this.tipo_mensaje = tipo_mensaje;
    }

    public String getTipo_mensaje() {
        return tipo_mensaje;
    }

    public void setTipo_mensaje(String tipo_mensaje) {
        this.tipo_mensaje = tipo_mensaje;
    }
       
}
