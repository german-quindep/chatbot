package com.example.chatbot.GeneratedPdf.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatbot.GeneratedPdf.Models.ComisionesModel;
import com.example.chatbot.GeneratedPdf.Models.ExColaboradorModel;
import com.example.chatbot.GeneratedPdf.Models.IngresosModel;
import com.example.chatbot.GeneratedPdf.Models.PdfModel;
import com.example.chatbot.GeneratedPdf.Services.PdfService;

@RestController
@RequestMapping("${api.index}${api.bot.index}")
public class PdfController {
    @Autowired
    private PdfService pdfService;

    @PostMapping("${api.bot.ex-colaborador}")
    public String genereatedExColaborador(@RequestBody ExColaboradorModel model) throws IOException {
        return pdfService.generatedExColaborador(model);
    }

    @PostMapping("${api.bot.ingresos}")
    public String genereatedIngresos(@RequestBody IngresosModel model) throws IOException {
        return pdfService.generatedIngreso(model);
    }

    @PostMapping("${api.bot.sinIngresos}")
    public String genereatedSinIngresos(@RequestBody PdfModel model) throws IOException {
        return pdfService.generatedSinIngresos(model);
    }

    @PostMapping("${api.bot.comisiones}")
    public String genereatedComisiones(@RequestBody ComisionesModel model) throws IOException {
        return pdfService.generatedComision(model);
    }

}
