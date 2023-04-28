package com.example.chatbot.TelegramBot.helpers;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

public class ImgSend {

    private String rutaImg = "static/img/";

    public File enviarFoto(String urlImg) throws IOException {
        // Obtener el archivo de la imagen
        File imageFile = new ClassPathResource(rutaImg + urlImg + ".png").getFile();
        return imageFile;
    }
}
