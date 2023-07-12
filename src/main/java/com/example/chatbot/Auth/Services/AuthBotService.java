package com.example.chatbot.Auth.Services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.Auth.DTO.ConsultAuthBot;
import com.example.chatbot.Auth.Models.AuthBot;
import com.example.chatbot.Auth.Repository.AuthBotRepository;

@Service
public class AuthBotService {
    private LocalDateTime fechaActual;
    @Autowired
    private AuthBotRepository authBotRepository;

    public AuthBot saveAuthBot(AuthBot authBot) {
        authBot.setFinish_token(authBot.sumGetTime());
        return authBotRepository.save(authBot);
    }

    public boolean geAuthBot(ConsultAuthBot consult) {
        AuthBot authData = authBotRepository.getBothAuth(consult);
        if (authData != null)
            return this.getFechaActual().isBefore(authData.getFinish_token());
        return false;
    }

    // VERIFICAR EL CHAT ID PARA VALIDAR LA SESION DE DHO
    public boolean getDhoBot(ConsultAuthBot consult) {
        AuthBot authDho = authBotRepository.getBothAuth(consult);
        // VALIDO EL ID DEL CHAT Y ADICIONAL SI TIENE UNA SESION
        if (authDho != null && authDho.getChatId().equals("5745294018"))
            return this.getFechaActual().isBefore(authDho.getFinish_token());
        return false;
    }

    // OBTENER LA FECHA ACTUAL
    private LocalDateTime getFechaActual() {
        this.fechaActual = LocalDateTime.now();
        return this.fechaActual;
    }

    // ACTUALIZAR EL TOKEN PARA DEJARLO INABILITADO
    public void deleteToken(ConsultAuthBot consult) {
        AuthBot auth = authBotRepository.getBothAuth(consult);
        if (auth == null)
            return;
        if (this.getFechaActual().isBefore(auth.getFinish_token())) {
            auth.setFinish_token(this.fechaActual.minusMinutes(15));
            authBotRepository.save(auth);
            return;
        }
    }
}
