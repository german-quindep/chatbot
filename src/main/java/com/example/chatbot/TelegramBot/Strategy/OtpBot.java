package com.example.chatbot.TelegramBot.Strategy;

import org.springframework.stereotype.Component;

import com.example.chatbot.TelegramBot.Model.ResponseBot;

@Component
public class OtpBot implements IBotStrategy {

    @Override
    public BotStrategyRegex getTypeBot() {
        return BotStrategyRegex.OTP;
    }

    @Override
    public ResponseBot executeAlgoritmo() {
        ResponseBot responseBot = new ResponseBot();
        responseBot.setReplyKeyboardMarkup(null);
        responseBot.setRespuesta("El número tiene 4 digitos es un otp");
        return responseBot;
    }

}
