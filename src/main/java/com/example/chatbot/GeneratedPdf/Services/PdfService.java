package com.example.chatbot.GeneratedPdf.Services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.thymeleaf.context.Context;

import com.example.chatbot.GeneratedPdf.Helpers.CertifiedWrite;
import com.example.chatbot.GeneratedPdf.Models.ComisionesModel;
import com.example.chatbot.GeneratedPdf.Models.ExColaboradorModel;
import com.example.chatbot.GeneratedPdf.Models.IngresosModel;
import com.example.chatbot.GeneratedPdf.Models.PdfModel;

@Service
public class PdfService {
    @Autowired
    private CertifiedWrite certifiedWrite;

    private Context ctx;

    public String generatedIngreso(IngresosModel model) throws IOException {
        this.ctx = new Context();
        this.ctx.setVariable("data", model);
        String data = certifiedWrite.archiveWrite(ctx, model.getFull_name(), "plantilla_ingresos");
        return data;
    }

    public String generatedExColaborador(ExColaboradorModel model) throws IOException {
        this.ctx = new Context();
        this.ctx.setVariable("data", model);
        String data = certifiedWrite.archiveWrite(ctx, model.getFull_name(), "plantilla_ex_colaborador");
        return data;
    }

    public String generatedSinIngresos(PdfModel model) throws IOException {
        this.ctx = new Context();
        this.ctx.setVariable("data", model);
        String data = certifiedWrite.archiveWrite(ctx, model.getFull_name(), "plantilla_sin_ingresos");
        return data;
    }

    public String generatedComision(ComisionesModel model) throws IOException {
        this.ctx = new Context();
        this.ctx.setVariable("data", model);
        String data = certifiedWrite.archiveWrite(ctx, model.getFull_name(), "plantilla_comisiones");
        return data;
    }
}
