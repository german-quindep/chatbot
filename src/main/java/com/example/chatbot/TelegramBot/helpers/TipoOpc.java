package com.example.chatbot.TelegramBot.helpers;

public enum TipoOpc {
    cola_activo {
        @Override
        public String toString() {
            return "Colaborador Activo";
        }
    },
    rol_pago {
        @Override
        public String toString() {
            return "Roles de Pago";
        }
    },
    certificados {
        @Override
        public String toString() {
            return "Certificados";
        }
    },
    vacaciones {
        @Override
        public String toString() {
            return "Vacaciones";
        }
    },
    cert_ingresos {
        @Override
        public String toString() {
            return "Certificado con ingresos";
        }
    },
    cert_sin_ingresos {
        @Override
        public String toString() {
            return "Certificado sin ingresos";
        }
    },
    cert_comision {
        @Override
        public String toString() {
            return "Certificado con comision";
        }
    },
    cert_pasantes {
        @Override
        public String toString() {
            return "Certificado de pasantes";
        }
    }
}
