package com.example.chatbot.Otp.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.chatbot.Otp.Dto.ConsultOtp;
import com.example.chatbot.Otp.Dto.ConsultOtpCedula;
import com.example.chatbot.Otp.Entity.Otp;
import com.example.chatbot.Otp.Repository.OtpRepository;
import com.example.chatbot.Otp.helpers.GenerateOtp;
import com.example.chatbot.Shared.messages.MsgBotError;
import com.example.chatbot.Shared.messages.MsgBotSuccess;

@Service
public class OtpService {
    @Autowired
    private OtpRepository otpRepository;

    public String saveOtp(String idChat, String cedula) {
        GenerateOtp generateOtp = new GenerateOtp();
        Otp otp = new Otp();
        otp.setCodigo(generateOtp.generatedOtp());
        otp.setStatus(false);
        otp.setInit_token(generateOtp.getInitToken());
        otp.setFinish_token(generateOtp.sumGetTime());
        otp.setIdChat(idChat);
        otp.setIdentificacion(cedula);
        Otp otpSave = otpRepository.save(otp);
        if (otpSave.getId() != null)
            return MsgBotSuccess.otpSave.toString();
        else
            return MsgBotError.otpSave.toString();
    }

    // GET USER CEDULA ID CHAT
    public String getIdChatOtpUser(String idChat) {
        Otp otp = otpRepository.finCedulaGet(idChat);
        if (otp != null)
            return otp.getIdentificacion();
        return null;
    }

    // VERIFICAR EL OTP
    public Otp getOtpUser(ConsultOtp otp) {
        return otpRepository.findByOtp(otp);
    }

    // VERIFICAR SI EXISTE UN OTP GENERADO EN EL MISMO CHAT
    public void getOtpChatUpdateIdentify(ConsultOtpCedula otpCedula) {
        Otp otp = otpRepository.findOtpCedula(otpCedula);
        if (otp != null)
            this.updateOtp(otp);
        return;
    }

    // ACTUALIZAR ESTADO
    public Otp updateOtp(Otp otp) {
        otp.setStatus(true);
        Otp otpUpdate = otpRepository.save(otp);
        if (otpUpdate.getId() != null)
            return otpUpdate;
        else
            return null;
    }
}
