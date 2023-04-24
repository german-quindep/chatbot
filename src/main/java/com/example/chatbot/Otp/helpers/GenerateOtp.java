package com.example.chatbot.Otp.helpers;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Random;

public class GenerateOtp {

    public GenerateOtp() {

    }

    public String generatedOtp() {
        String otp = new DecimalFormat("0000").format(new Random().nextInt(9999));
        return otp;
    }

    public LocalDateTime sumGetTime() {
        return LocalDateTime.now().plusMinutes(10);
    }

    public LocalDateTime getInitToken() {
        return LocalDateTime.now();
    }

    public boolean compareFecha(LocalDateTime fechaFinish) {
        return this.getInitToken().compareTo(fechaFinish) > 0;
    }
}
