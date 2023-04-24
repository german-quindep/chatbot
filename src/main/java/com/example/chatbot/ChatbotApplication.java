package com.example.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.example.chatbot.TelegramBot.Config.TelegramBotConfig;

@SpringBootApplication
public class ChatbotApplication {

	public static void main(String[] args) {
		// You can use your own BotSession implementation if needed.
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(new TelegramBotConfig());
		} catch (TelegramApiException ex) {
			ex.printStackTrace();
		}

		SpringApplication.run(ChatbotApplication.class, args);
	}

}
