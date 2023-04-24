package com.example.chatbot.TelegramBot.Strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.chatbot.Otp.Service.OtpService;
import com.example.chatbot.TelegramBot.Menu.MenuUsers;
import com.example.chatbot.TelegramBot.Model.ResponseBot;

@Component
public class CedulaBot implements IBotStrategy {

  @Autowired
  private OtpService otp;

  @Override
  public BotStrategyRegex getTypeBot() {
    return BotStrategyRegex.CEDULA;
  }

  @Override
  public ResponseBot executeAlgoritmo() {
    ResponseBot responseBot = new ResponseBot();
    responseBot.setReplyKeyboardMarkup(MenuUsers.getMenuAuthCheck());
    responseBot.setRespuesta(otp.saveOtp());
    return responseBot;
  }

}
