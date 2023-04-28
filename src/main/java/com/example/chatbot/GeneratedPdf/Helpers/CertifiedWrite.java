package com.example.chatbot.GeneratedPdf.Helpers;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class CertifiedWrite {
    @Autowired
    private TemplateEngine templateEngine;
    private static String URL_HTML = "src/main/resources/templates/";

    public String archiveWrite(Context ctx, String name, String template) throws IOException {
        String htmlContent = templateEngine.process(template, ctx);
        String fileHtml = URL_HTML + name + ".html";
        // Crea un objeto FileWriter con el nombre del archivo
        try {
            FileWriter fileWriter = new FileWriter(fileHtml);
            // Escribe el contenido del nuevo HTML en el archivo
            fileWriter.write(htmlContent);
            // Cierra el FileWriter
            fileWriter.close();
            return "ok";

        } catch (Exception ex) {
            return "error";
        }
    }
}
