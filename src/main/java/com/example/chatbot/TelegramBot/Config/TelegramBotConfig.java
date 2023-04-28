package com.example.chatbot.TelegramBot.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.example.chatbot.TelegramBot.helpers.ConsumeApi;

@Component
public class TelegramBotConfig extends TelegramLongPollingBot {

    @Value("${bot.user}")
    public String namebot;
    @Value("${bot.token}")
    public String tokenbot;

    public ConsumeApi consumeApi;

    @Override
    public void onUpdateReceived(Update update) {
        // Se obtiene el mensaje escrito por el usuario
        this.consumeApi = new ConsumeApi();
        final String messageTextReceived = update.getMessage().getText();
        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();
        // Se crea un objeto mensaje
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        ResponseBot mensajeFinal = this.consumeApi.getSolicitud(messageTextReceived);
        message.setText(mensajeFinal.getRespuesta());
        message.setReplyMarkup(mensajeFinal.getReplyKeyboardMarkup());
        try {
            // Se envía el mensaje
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        // CUANDO SEA IMAGEN DEBE ENVIAR LA IMAGEN
        if (mensajeFinal.getPathFile() != null) {
            // ENVIO EL PATH IMG PARA ENVIARLO
            InputFile imgFinal = new InputFile(mensajeFinal.getPathFile());
            this.sendPdfOrImg(message.getChatId().toString(), imgFinal);
        }
    }

    @Override
    public String getBotUsername() {
        return "";
    }

    @Override
    public String getBotToken() {
        return "";
    }

    private void sendPdfOrImg(String chatId, InputFile ruta) {
        if (ruta.getAttachName().toString().endsWith(".pdf")) {
            SendPhoto sendPhoto = new SendPhoto(chatId, ruta);
            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            SendDocument sendDocument = new SendDocument(chatId, ruta);
            try {
                execute(sendDocument);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
