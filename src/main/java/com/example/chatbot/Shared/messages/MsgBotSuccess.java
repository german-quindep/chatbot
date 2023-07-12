package com.example.chatbot.Shared.messages;

public enum MsgBotSuccess {
    token {
        @Override
        public String toString() {
            return "El token a sido autenticado de manera exitosa";
        }
    },
    otpSave {
        @Override
        public String toString() {
            return "Se guardo con exito el otp, se te enviara un correo con ese codigo";
        }
    },
}
