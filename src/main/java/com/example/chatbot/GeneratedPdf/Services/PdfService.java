package com.example.chatbot.GeneratedPdf.Services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.thymeleaf.context.Context;

import com.example.chatbot.GeneratedPdf.Dto.ConsultPdfUSer;
import com.example.chatbot.GeneratedPdf.Entity.PdfUser;
import com.example.chatbot.GeneratedPdf.Helpers.CertifiedWrite;
import com.example.chatbot.GeneratedPdf.Models.ComisionesModel;
import com.example.chatbot.GeneratedPdf.Models.ExColaboradorModel;
import com.example.chatbot.GeneratedPdf.Models.IngresosModel;
import com.example.chatbot.GeneratedPdf.Models.PdfModel;
import com.example.chatbot.GeneratedPdf.Repository.PdfUserRepository;

@Service
public class PdfService {
    @Autowired
    private CertifiedWrite certifiedWrite;
    @Autowired
    private PdfUserRepository pdfUserRepository;
    private Context ctx;

    public String generatedIngreso(IngresosModel model) throws IOException {
        this.ctx = new Context();
        this.ctx.setVariable("data", model);
        String data = certifiedWrite.archiveWrite(ctx, model.getFull_name() + "-" + "con-ingresos",
                "plantilla_ingresos");
        return data;
    }

    public String generatedSinIngresos(PdfModel model) throws IOException {
        this.ctx = new Context();
        this.ctx.setVariable("data", model);
        // RETURNO LA RUTA DEL ARCHIVO GENERADO
        String data = certifiedWrite.archiveWrite(ctx, model.getFull_name() + "-" + "sin-ingresos",
                "plantilla_sin_ingresos");
        return data;

    }

    public String generatedExColaborador(ExColaboradorModel model) throws IOException {
        this.ctx = new Context();
        this.ctx.setVariable("data", model);
        String data = certifiedWrite.archiveWrite(ctx, model.getFull_name() + "-" + "ex-colaborador",
                "plantilla_ex_colaborador");
        return data;
    }

    public String generatedComision(ComisionesModel model) throws IOException {
        this.ctx = new Context();
        this.ctx.setVariable("data", model);
        String data = certifiedWrite.archiveWrite(ctx, model.getFull_name() + "-" + "con-comisiones",
                "plantilla_comisiones");
        return data;
    }

    public PdfUser savePdfUser(PdfUser model) {
        PdfUser pdfUser = pdfUserRepository.save(model);
        if (pdfUser != null)
            return pdfUser;
        return null;

    }

    public PdfUser getOneUser(ConsultPdfUSer consult) {
        return pdfUserRepository.getPdfUser(consult);
    }
}
