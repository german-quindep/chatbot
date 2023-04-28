package com.example.chatbot.TelegramBot.Service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.Shared.Validation.RegexBot;
import com.example.chatbot.TelegramBot.Menu.MenuUsers;
import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.example.chatbot.TelegramBot.Model.TBotModel;
import com.example.chatbot.TelegramBot.Strategy.BotStrategyRegex;
import com.example.chatbot.TelegramBot.Strategy.Service.BotStrategyService;
import com.example.chatbot.TelegramBot.helpers.ImgSend;

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
            responseBot.setPathFile(null);
            responseBot.setRespuesta("No entiendo bien el mensaje por favor escribe 'hola' nuevamente");
        }
        return responseBot;
    }

    public ResponseBot sendImg(TBotModel tBotModel) throws IOException {
        ResponseBot responseBot = new ResponseBot();
        ImgSend imgSend = new ImgSend();
        File filePath = imgSend.enviarFoto(tBotModel.getTipo_mensaje());
        responseBot.setRespuesta("Ok te envio la imagen");
        responseBot.setReplyKeyboardMarkup(MenuUsers.getMenuPrincipal());
        responseBot.setPathFile(filePath);
        return responseBot;
    }
}
