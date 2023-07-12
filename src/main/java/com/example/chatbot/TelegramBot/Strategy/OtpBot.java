package com.example.chatbot.TelegramBot.Strategy;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.chatbot.Auth.Models.AuthBot;
import com.example.chatbot.Auth.Services.AuthBotService;
import com.example.chatbot.Otp.Dto.ConsultOtp;
import com.example.chatbot.Otp.Entity.Otp;
import com.example.chatbot.Otp.Service.OtpService;
import com.example.chatbot.Shared.helpers.ReplaceSpace;
import com.example.chatbot.Shared.messages.MsgBotError;
import com.example.chatbot.Shared.messages.MsgBotSuccess;
import com.example.chatbot.TelegramBot.Model.ResponseBot;

@Component
public class OtpBot implements IBotStrategy {
    private LocalDateTime fechaActual;
    @Autowired
    private OtpService otpService;
    @Autowired
    private AuthBotService authBotService;

    @Override
    public BotStrategyRegex getTypeBot() {
        return BotStrategyRegex.OTP;
    }

    @Override
    public ResponseBot executeAlgoritmo(String numero) {
        ReplaceSpace replace = new ReplaceSpace(numero);
        String texto[] = replace.replaceComaList();
        ConsultOtp consult = new ConsultOtp(texto[1], texto[0]);
        Otp otpNew = otpService.getOtpUser(consult);
        ResponseBot responseBot = new ResponseBot();
        // VERIFICAR TOKEN
        if (otpNew == null || this.getFechaActual().isAfter(otpNew.getFinish_token())) {
            responseBot.setReplyKeyboardMarkup(null);
            responseBot.setRespuesta(MsgBotError.token.toString());
            return responseBot;
        }
        responseBot.setReplyKeyboardMarkup(null);
        this.updateState(otpNew);
        this.saveAuthBot(texto[1]);
        responseBot.setRespuesta(MsgBotSuccess.token.toString());
        return responseBot;
    }

    // OBTENER LA FECHA ACTUAL
    private LocalDateTime getFechaActual() {
        this.fechaActual = LocalDateTime.now();
        return this.fechaActual;
    }

    // ACTUALIZAR EL ESTADO
    private Otp updateState(Otp otp) {
        return otpService.updateOtp(otp);
    }

    // GUARDAR EL NUEVO OTP
    private AuthBot saveAuthBot(String idChat) {
        AuthBot authBot = new AuthBot();
        authBot.setChatId(idChat);
        return authBotService.saveAuthBot(authBot);
    }
}
