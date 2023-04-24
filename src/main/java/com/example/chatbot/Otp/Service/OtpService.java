package com.example.chatbot.Otp.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.chatbot.Otp.Entity.Otp;
import com.example.chatbot.Otp.Repository.OtpRepository;
import com.example.chatbot.Otp.helpers.GenerateOtp;

@Service
public class OtpService {
    @Autowired
    private OtpRepository otpRepository;

    public String saveOtp() {
        GenerateOtp generateOtp = new GenerateOtp();
        Otp otp = new Otp();
        otp.setCodigo(generateOtp.generatedOtp());
        otp.setStatus(false);
        otp.setInit_token(generateOtp.getInitToken());
        otp.setFinish_token(generateOtp.sumGetTime());
        Otp otpSave = otpRepository.save(otp);
        if (otpSave.getId() != null)
            return "Se guardo con exito el otp, se te enviara un correo con ese codigo";
        else
            return "Algo ocurrio intentelo mas tarde";
    }
}
