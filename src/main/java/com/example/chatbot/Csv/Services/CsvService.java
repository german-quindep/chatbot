package com.example.chatbot.Csv.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.chatbot.Csv.Helpers.CsvBase64;
import com.example.chatbot.Csv.Models.Base64Model;
import com.example.chatbot.Shared.Response.Model.Response;
import com.example.chatbot.Shared.Validation.ValidateFile;
import com.example.chatbot.Shared.messages.MsgError;
import com.example.chatbot.Shared.messages.MsgSuccess;
import com.example.chatbot.Users.Entity.Usuario;
import com.example.chatbot.Users.Repository.UsuarioRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class CsvService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private static final String UPLOAD_DIR = "csv";
    private String nameArchivo = "gquinde.csv";
    private CsvBase64 csvBase64;

    public Response<String, String> uploadCsvFile(MultipartFile file) throws IOException {
        Response<String, String> respo = new Response<>();
        this.nameArchivo = file.getOriginalFilename();
        if (ValidateFile.validateExtension(this.nameArchivo)) {
            respo.ResponseError(MsgError.error.toString(), 400, MsgError.failedCsv.toString());
            return respo;
        }
        try {
            Path rutaArchivo = Paths.get(UPLOAD_DIR + "/" + this.nameArchivo);
            Files.copy(file.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);
            respo.ResponseSuccess(MsgSuccess.ok.toString(), 200, MsgSuccess.fileUpdate.toString());
            return respo;
        } catch (IOException ex) {
            respo.ResponseError(MsgError.error.toString(), 400, MsgError.catchFile.toString());
            return respo;
        }
    }

    public Response<String, String> saveCsvBD() {
        Response<String, String> respo = new Response<>();
        File fileExist = new File(UPLOAD_DIR, this.nameArchivo);
        if (ValidateFile.validateExist(fileExist)) {
            respo.ResponseError(MsgError.error.toString(), 400,
                    MsgError.notFoundFile.toString());
            return respo;
        }
        try {
            Path rutaArchivo = Paths.get(UPLOAD_DIR + "/" + this.nameArchivo);
            CSVReader reader = new CSVReaderBuilder(new FileReader(rutaArchivo.toFile())).withSkipLines(1).build();
            String[] fila;
            while ((fila = reader.readNext()) != null) { // recorrer el archivo e insertarlo en la bd
                Usuario datosCsv = new Usuario();
                datosCsv.setNombre(fila[0]);
                datosCsv.setApellido(fila[1]);
                datosCsv.setEmail(fila[2]);
                usuarioRepository.save(datosCsv);
            }
            reader.close(); // cerar la lectura
            respo.ResponseSuccess(MsgSuccess.ok.toString(), 200, MsgSuccess.updateBd.toString());
            return respo;
        } catch (Exception ex) {
            respo.ResponseError(MsgError.error.toString(), 400, MsgError.catchFileUpdateBd.toString());
            return respo;
        }
    }

    public Response<Base64Model, String> csvBase64() {
        Response<Base64Model, String> respo = new Response<>();
        try {
            this.csvBase64 = new CsvBase64(UPLOAD_DIR, this.nameArchivo);
            String base64 = this.csvBase64.base64Convert();
            if (base64 != null) {
                Base64Model base64Model = new Base64Model(base64);
                respo.ResponseSuccess(MsgSuccess.ok.toString(), 200, base64Model);
                return respo;
            }
            respo.ResponseError(MsgError.error.toString(), 400, MsgError.catchBase64.toString());
            return respo;
        } catch (Exception ex) {
            respo.ResponseError(MsgError.error.toString(), 400, MsgError.catchBase64.toString());
            return respo;
        }

    }
}
