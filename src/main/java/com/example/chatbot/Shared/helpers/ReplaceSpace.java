package com.example.chatbot.Shared.helpers;

public class ReplaceSpace {
    public String texto;
    public String textoOriginal;

    public ReplaceSpace() {
    }

    public ReplaceSpace(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoOriginal() {
        return textoOriginal;
    }

    public void setTextoOriginal(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public String replaceText() {
        this.texto = this.textoOriginal.replace(" ", "-");
        return this.texto.toLowerCase();
    }
}
