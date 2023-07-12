package com.example.chatbot.TelegramBot.Config;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class InitializerBot {
    public InitializerBot(TelegramBotConfig botConfig) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(botConfig);
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}
