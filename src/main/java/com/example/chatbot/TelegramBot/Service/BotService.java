package com.example.chatbot.TelegramBot.Service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.OpcionesBot.Service.OpcBotService;
import com.example.chatbot.Shared.Validation.RegexBot;
import com.example.chatbot.Shared.messages.MsgBotError;
import com.example.chatbot.TelegramBot.Menu.MenuUsers;
import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.example.chatbot.TelegramBot.Model.TBotModel;
import com.example.chatbot.TelegramBot.Strategy.BotStrategyRegex;
import com.example.chatbot.TelegramBot.Strategy.Service.BotStrategyService;
import com.example.chatbot.TelegramBot.helpers.ImgSend;
import com.example.chatbot.WebService.ConsumerWS;

@Service
public class BotService {

    @Autowired
    private BotStrategyService botStrategyService;
    @Autowired
    private OpcBotService opcBotService;
    @Autowired
    private ConsumerWS consumerWS;

    public ResponseBot validateNumber(String numero, TBotModel tBotModel) {
        ResponseBot responseBot = new ResponseBot();
        for (RegexBot regex : RegexBot.values()) {
            if (regex.isValid(numero)) {
                BotStrategyRegex botStrategyRegex = BotStrategyRegex.valueOf(regex.getmessageType());
                responseBot = botStrategyService.executeAlgoritmo(botStrategyRegex,
                        numero + "," + tBotModel.getIdChat());
                break;
            }
            responseBot.setReplyKeyboardMarkup(null);
            responseBot.setPathFile(null);
            responseBot.setRespuesta(MsgBotError.botErrorMsg.toString());
        }
        return responseBot;
    }

    public ResponseBot sendPdf(TBotModel tBotModel, String tipo) throws IOException {
        ResponseBot responseBot = new ResponseBot();
        ImgSend imgSend = new ImgSend();
        String url = consumerWS.getFindUserPdf(tBotModel.getIdChat(), tipo);
        // BUSCO EL ARCHIVO GENERADO PARA REALIZAR EL ENVIO
        File filePath = imgSend.sendPdf(url);
        responseBot.setRespuesta("Ok te envio el pdf");
        opcBotService.saveOpcBot(tBotModel.getIdChat(), tBotModel.getTipo_mensaje());
        responseBot.setReplyKeyboardMarkup(MenuUsers.getMenuPrincipal());
        responseBot.setPathFile(filePath);
        return responseBot;
    }

    public ResponseBot sendImg(TBotModel tBotModel) throws IOException {
        ResponseBot responseBot = new ResponseBot();
        ImgSend imgSend = new ImgSend();
        File filePath = imgSend.enviarFoto(tBotModel.getTipo_mensaje());
        responseBot.setRespuesta("Ok te envio la imagen");
        opcBotService.saveOpcBot(tBotModel.getIdChat(), tBotModel.getTipo_mensaje());
        responseBot.setReplyKeyboardMarkup(MenuUsers.getMenuPrincipal());
        responseBot.setPathFile(filePath);
        return responseBot;
    }

    public ResponseBot sendExColaborador(TBotModel tBotModel) {
        ResponseBot responseBot = new ResponseBot();
        responseBot.setRespuesta(
                "Ok ayudame con un csv para enviarte los certificados");
        responseBot.setReplyKeyboardMarkup(null);
        responseBot.setPathFile(null);
        return responseBot;
    }
}
