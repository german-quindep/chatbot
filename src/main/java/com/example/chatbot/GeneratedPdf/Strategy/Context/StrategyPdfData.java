package com.example.chatbot.GeneratedPdf.Strategy.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.GeneratedPdf.Strategy.StrategyPdf;
import com.example.chatbot.GeneratedPdf.Strategy.TypePdf;

import jakarta.annotation.PostConstruct;

@Service
public class StrategyPdfData {
    @Autowired
    private List<StrategyPdf> robotStrategies;
    private Map<TypePdf, StrategyPdf> map;

    @PostConstruct
    public void setup() {
        this.map = new HashMap<>();
        robotStrategies.forEach(robotStrategies -> map.put(robotStrategies.getTypeBot(), robotStrategies));
    }

    public String executePdf(TypePdf robotType, String jsonData) {
        return this.map.get(robotType).crearPdf(jsonData);
    }
}
