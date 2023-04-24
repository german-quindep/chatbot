package com.example.chatbot.Shared.messages;

public enum MsgError {
    error {
        @Override
        public String toString() {
            return "error";
        }
    },
    failedCsv {
        @Override
        public String toString() {
            return "No se pudo almacenar el archivo ya que no es un csv";
        }
    },
    notFoundFile {
        @Override
        public String toString() {
            return "El archivo no se encuentra disponible en la ruta, por favor subalo y vuelva a intentarlo";
        }
    },
    catchFile {
        @Override
        public String toString() {
            return "No se pudo almacenar el archivo, por favor, inténtalo de nuevo.";
        }
    },
    catchFileUpdateBd {
        @Override
        public String toString() {
            return "No se guardo en la base de datos, por favor inténtalo de nuevo.";
        }
    },
    catchBase64 {
        @Override
        public String toString() {
            return "No se proceso el archivo, intentelo mas tarde";
        }
    }
}
