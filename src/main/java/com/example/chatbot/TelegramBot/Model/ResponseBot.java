package com.example.chatbot.TelegramBot.Model;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class ResponseBot {
    private ReplyKeyboardMarkup replyKeyboardMarkup;
    private String respuesta;

    
    public ResponseBot() {
    }

    public ResponseBot(ReplyKeyboardMarkup replyKeyboardMarkup, String respuesta) {
        this.replyKeyboardMarkup = replyKeyboardMarkup;
        this.respuesta = respuesta;
    }

    public ReplyKeyboardMarkup getReplyKeyboardMarkup() {
        return replyKeyboardMarkup;
    }

    public void setReplyKeyboardMarkup(ReplyKeyboardMarkup replyKeyboardMarkup) {
        this.replyKeyboardMarkup = replyKeyboardMarkup;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
