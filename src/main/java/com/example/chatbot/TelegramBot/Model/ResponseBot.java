package com.example.chatbot.TelegramBot.Model;

import java.io.File;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class ResponseBot {
    private ReplyKeyboardMarkup replyKeyboardMarkup;
    private String respuesta;
    private File pathFile;

    public ResponseBot() {
    }

    public ResponseBot(ReplyKeyboardMarkup replyKeyboardMarkup, String respuesta, File pathFile) {
        this.replyKeyboardMarkup = replyKeyboardMarkup;
        this.respuesta = respuesta;
        this.pathFile = pathFile;
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

    public File getPathFile() {
        return pathFile;
    }

    public void setPathFile(File pathFile) {
        this.pathFile = pathFile;
    }

}
