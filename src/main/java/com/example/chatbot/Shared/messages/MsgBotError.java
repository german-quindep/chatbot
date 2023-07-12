package com.example.chatbot.Shared.messages;

public enum MsgBotError {
    token {
        @Override
        public String toString() {
            return "El token a expirado, porfavor vuelva a pedir un token, escribiendo su identificación";
        }
    },
    otpSave {
        @Override
        public String toString() {
            return "Algo ocurrio al generar el codigo, porfavor intentelo más tarde";
        }
    },
    botErrorMsg {
        @Override
        public String toString() {
            return "No entiendo bien el mensaje por favor escribe 'hola' nuevamente";
        }
    },
    authOrToken {
        @Override
        public String toString() {
            return "Parece que la sesión expiro o posiblemente no te haz autenticado por favor escribe 'hola' para empezar de nuevo";
        }
    },
    authDhoToken {
        @Override
        public String toString() {
            return "Ups!! Creo que esta opción no es válida para tu usuario por favor digite 'hola' nuevamente";
        }
    },
    notDataUser {
        @Override
        public String toString() {
            return "porfavor vuelva a intentarlo";
        }
    },
    bloqUserGet {
        @Override
        public String toString() {
            return "Usted se encuentra bloqueado contactese con DHO y verifique";
        }
    },
    bloqUserSave {
        @Override
        public String toString() {
            return "Se a bloqueado tu usuario por el exceso de intento en autenticarte, comunicate con DHO para revisar tu cédula";
        }
    },
    intenosAdvertencia {
        @Override
        public String toString() {
            return "No te encuentras registrado, recuerda que por 3 intentos el bot puede bloquear el usuario, por favor vuelve a intentarlo";
        }
    }
}
