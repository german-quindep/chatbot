package com.example.chatbot.TelegramBot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.Shared.Validation.RegexBot;
import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.example.chatbot.TelegramBot.Strategy.BotStrategyRegex;
import com.example.chatbot.TelegramBot.Strategy.Service.BotStrategyService;

@Service
public class BotService {

    @Autowired
    private BotStrategyService botStrategyService;

    public ResponseBot validateNumber(String numero) {
        ResponseBot responseBot = new ResponseBot();
        // Validar que el número tenga 10 dígitos
        for (RegexBot regex : RegexBot.values()) {
            if (regex.isValid(numero)) {
                BotStrategyRegex botStrategyRegex = BotStrategyRegex.valueOf(regex.getmessageType());
                responseBot = botStrategyService.executeAlgoritmo(botStrategyRegex);
                break;
            }
            responseBot.setReplyKeyboardMarkup(null);
            responseBot.setRespuesta("No entiendo bien el mensaje por favor escribe 'hola' nuevamente");
        }
        return responseBot;
    }
}
