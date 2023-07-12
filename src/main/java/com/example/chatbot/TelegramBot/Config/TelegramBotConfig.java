package com.example.chatbot.TelegramBot.Config;

import java.util.HashMap;
import java.util.Map;

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
    private String namebot;
    @Value("${bot.token}")
    private String tokenbot;
    @Value("${urlApi}${api.bot.index}/")
    public String apiUrl;
    // HASHMAP para almacenar el estado del chat
    private final Map<Long, TelegramBotMultiChat> userBots = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Se obtiene el mensaje escrito por el usuario
            final String messageTextReceived = update.getMessage().getText();
            // Se obtiene el id de chat del usuario
            final long chatId = update.getMessage().getChatId();
            TelegramBotMultiChat bot = userBots.computeIfAbsent(chatId, id -> new TelegramBotMultiChat(apiUrl));
            ResponseBot mensajeFinal = bot.responseMulti(messageTextReceived, chatId);
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(mensajeFinal.getRespuesta());
            message.setReplyMarkup(mensajeFinal.getReplyKeyboardMarkup());
            try {
                // Se envía el mensaje
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            // CUANDO SEA IMAGEN
            if (mensajeFinal.getPathFile() != null) {
                // ENVIO EL PATH IMG PARA ENVIARLO
                InputFile imgFinal = new InputFile(mensajeFinal.getPathFile());
                this.sendPdfOrImg(message.getChatId().toString(), imgFinal);
            }
        }

    }

    @Override
    public String getBotUsername() {
        return namebot;
    }

    @Override
    public String getBotToken() {
        return tokenbot;
    }

    private void sendPdfOrImg(String chatId, InputFile ruta) {
        if (ruta.getAttachName().toString().endsWith(".png")) {
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

    // MULTIPLE CHAT SIMULTANEO
    private static class TelegramBotMultiChat {
        public ConsumeApi consumeApi;
        public String apiUrl;

        public TelegramBotMultiChat(String apiUrl) {
            this.apiUrl = apiUrl;
        }

        public ResponseBot responseMulti(String messageTextReceived, Long chatId) {
            this.consumeApi = new ConsumeApi(apiUrl);
            ResponseBot mensajeFinal = this.consumeApi.getSolicitud(messageTextReceived, chatId);
            return mensajeFinal;
        }
    }
}
