package com.example.chatbot.TelegramBot.Model;

public class TBotModel {
    private String tipo_mensaje;
    private String idChat;

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public TBotModel() {
    }

    public TBotModel(String tipo_mensaje, String idChat) {
        this.tipo_mensaje = tipo_mensaje;
        this.idChat = idChat;
    }

    public String getTipo_mensaje() {
        return tipo_mensaje;
    }

    public void setTipo_mensaje(String tipo_mensaje) {
        this.tipo_mensaje = tipo_mensaje;
    }

}
