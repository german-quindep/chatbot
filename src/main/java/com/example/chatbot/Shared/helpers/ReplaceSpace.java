package com.example.chatbot.Shared.helpers;

import lombok.Data;

@Data
public class ReplaceSpace {
    public String texto;
    public String textoOriginal;

    public ReplaceSpace() {
    }

    public ReplaceSpace(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public String replaceText() {
        this.texto = this.textoOriginal.replace(" ", "-");
        return this.texto.toLowerCase();
    }

    public String replaceOneComa() {
        this.texto = this.textoOriginal.split(",")[1];
        return texto;
    }

    public String[] replaceComaList() {
        String texto[] = this.textoOriginal.split(",");
        return texto;
    }
}
