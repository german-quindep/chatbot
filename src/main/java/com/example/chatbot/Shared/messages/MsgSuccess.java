package com.example.chatbot.Shared.messages;

public enum MsgSuccess {
    ok {
        @Override
        public String toString() {
            return "ok";
        }
    },
    fileUpdate {
        @Override
        public String toString() {
            return "El archivo se subio con exito";
        }
    },
    updateBd {
        @Override
        public String toString() {
            return "Se actualizo la base de datos";
        }
    },
    archive64 {
        @Override
        public String toString() {
            return "Se genero con exito el archivo";
        }
    }
}
