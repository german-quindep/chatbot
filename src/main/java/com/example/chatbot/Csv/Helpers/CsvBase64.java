package com.example.chatbot.Csv.Helpers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class CsvBase64 {
    public String archivo;
    private String base64;
    private String URL_ARCHIVE = "csv";
    private String nameArchivo = "gquinde.csv";
    private byte[] csvBytes;

    public CsvBase64(String URL_ARCHIVE, String nameArchivo) {
        this.URL_ARCHIVE = URL_ARCHIVE;
        this.nameArchivo = nameArchivo;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String base64Convert() {
        try {
            this.csvBytes = Files.readAllBytes(Paths.get(this.URL_ARCHIVE + "/" + this.nameArchivo));
            this.base64 = Base64.getEncoder().encodeToString(this.csvBytes);
            return base64;
        } catch (Exception ex) {
            //ex.printStackTrace();
            return null;
        }
    }
}
