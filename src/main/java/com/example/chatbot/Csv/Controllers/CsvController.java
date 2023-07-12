package com.example.chatbot.Csv.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.chatbot.Csv.Services.CsvService;

@RestController
@RequestMapping("${api.index}${api.csv.index}")
public class CsvController {
    @Autowired
    private CsvService csvService;

    @PostMapping("${api.csv.update}")
    public ResponseEntity<?> uploadCsv(@RequestParam("file") MultipartFile file) throws IOException {
        return csvService.uploadCsvFile(file);
    }

    @GetMapping("${api.csv.updateBd}")
    public ResponseEntity<?> updateBD() {
        return csvService.saveCsvBD();
    }

    @GetMapping("${api.csv.base}")
    public ResponseEntity<?> getBase64() {
        return csvService.csvBase64();
    }
}
