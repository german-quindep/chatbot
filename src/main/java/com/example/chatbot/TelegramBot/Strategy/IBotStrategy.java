package com.example.chatbot.TelegramBot.Strategy;

import com.example.chatbot.TelegramBot.Model.ResponseBot;

public interface IBotStrategy {
    BotStrategyRegex getTypeBot();
    ResponseBot executeAlgoritmo();
}
