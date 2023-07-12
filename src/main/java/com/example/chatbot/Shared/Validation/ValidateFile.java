package com.example.chatbot.Shared.Validation;

import java.io.File;

public class ValidateFile {

    private static final String CSV_EXTENSION = ".csv";

    public static boolean validateExtension(String nameArchivo) {
        return !nameArchivo.toLowerCase().endsWith(CSV_EXTENSION);
    }

    public static boolean validateExist(File fileExist) {
        return !fileExist.exists();
    }

}
