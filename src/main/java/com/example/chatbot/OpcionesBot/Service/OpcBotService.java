package com.example.chatbot.OpcionesBot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.OpcionesBot.Model.OpcionesBot;
import com.example.chatbot.OpcionesBot.Repository.OpcBotRepository;
import com.example.chatbot.Shared.messages.MsgBotError;
import com.example.chatbot.Shared.messages.MsgBotSuccess;

@Service
public class OpcBotService {
    @Autowired
    private OpcBotRepository opcBotRepository;

    public String saveOpcBot(String identificacion, String tipo) {
        OpcionesBot opcionesBot = new OpcionesBot(identificacion, tipo);
        OpcionesBot opResult = opcBotRepository.save(opcionesBot);
        if (opResult.getId() != null)
            return MsgBotSuccess.otpSave.toString();
        else
            return MsgBotError.otpSave.toString();
    }
}
