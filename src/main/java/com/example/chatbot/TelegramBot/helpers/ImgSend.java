package com.example.chatbot.TelegramBot.helpers;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

public class ImgSend {

    private String rutaImg = "static/img/";
    private String archiveRuta="/home/german/Escritorio/spring_proyecto/chatbot/archive/";

    public File enviarFoto(String urlImg) throws IOException {
        // Obtener el archivo de la imagen
        File imageFile = new ClassPathResource(rutaImg + urlImg + ".png").getFile();
        return imageFile;
    }

    public File sendPdf(String urlPdf) throws IOException {
        // Obtener el archivo del PDF
        File archive = new File(archiveRuta + urlPdf + ".html");
        return archive;
    }
}
