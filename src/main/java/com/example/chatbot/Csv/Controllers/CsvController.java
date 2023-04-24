package com.example.chatbot.Csv.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.chatbot.Csv.Models.Base64Model;
import com.example.chatbot.Csv.Services.CsvService;
import com.example.chatbot.Shared.Response.Model.Response;

@RestController
@RequestMapping("${api.index}${api.csv.index}")
public class CsvController {
    @Autowired
    private CsvService csvService;

    @PostMapping("${api.csv.update}")
    public Response<String, String> uploadCsv(@RequestParam("file") MultipartFile file) throws IOException {
        return csvService.uploadCsvFile(file);
    }

    @GetMapping("${api.csv.updateBd}")
    public Response<String, String> updateBD() {
        return csvService.saveCsvBD();
    }

    @GetMapping("${api.csv.base}")
    public Response<Base64Model, String> getBase64() {
        return csvService.csvBase64();
    }
}
