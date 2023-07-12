package com.example.chatbot.TelegramBot.Strategy;

import org.springframework.stereotype.Component;

import com.example.chatbot.TelegramBot.Model.ResponseBot;

@Component
public class FechaBot implements IBotStrategy {

    @Override
    public BotStrategyRegex getTypeBot() {
        return BotStrategyRegex.FECHA;
    }

    @Override
    public ResponseBot executeAlgoritmo(String numero) {
        ResponseBot responseBot = new ResponseBot();
        responseBot.setReplyKeyboardMarkup(null);
        responseBot.setRespuesta("El número tiene una fecha especifica");
        return responseBot;
    }

}
