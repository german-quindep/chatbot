package com.example.chatbot.BloqUser.Services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.chatbot.BloqUser.Models.BloqUserModel;
import com.example.chatbot.BloqUser.Repository.BloqUserRepository;
import com.example.chatbot.Shared.messages.MsgBotError;

@Service
public class BloqUserService {

    @Autowired
    private BloqUserRepository bloqUserRepository;

    // METODO PARA BLOQUEAR AL USUARIO POR EL EXCESO DE INTENTO
    public String saveBloqUser(String idChat) {
        BloqUserModel userIntento = getUserIntentos(idChat);
        if (userIntento != null && userIntento.getIntentos() == 3)
            return MsgBotError.bloqUserSave.toString();
        if (userIntento != null) {
            userIntento.setIntentos(userIntento.getIntentos() + 1);
            bloqUserRepository.save(userIntento);
            return "Aún te quedan " + userIntento.getIntentos().toString() + ", vuelve a intenarlo";
        }
        BloqUserModel bloqUserModel = new BloqUserModel();
        bloqUserModel.setIdChat(idChat);
        bloqUserModel.setIntentos(1);
        bloqUserRepository.save(bloqUserModel);
        return MsgBotError.intenosAdvertencia.toString();
    }
    //INTENTOS DE USUARIOS PARA BLOQUWAR
    public BloqUserModel getUserIntentos(String idChat) {
        return bloqUserRepository.getIntentosUser(idChat);
    }

    // METODO PARA VERIFICAR SI EL USUARIO ESTA BLOQUEADO
    public boolean getUserbloq(String idChat) {
        BloqUserModel bloqUserModel = bloqUserRepository.getBloqUser(idChat);
        return bloqUserModel != null ? true : false;
    }
}
