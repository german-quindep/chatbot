package com.example.chatbot.GeneratedPdf.Strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.chatbot.GeneratedPdf.Helpers.JsonReplace;

@Component
public class ConComision implements StrategyPdf {
    @Autowired
    private JsonReplace jsonReplace;

    @Override
    public TypePdf getTypeBot() {
        return TypePdf.CON_COMISION;
    }

    @Override
    public String crearPdf(String jsonData) {
        return jsonReplace.getIngresosModel(jsonData);
    }
}