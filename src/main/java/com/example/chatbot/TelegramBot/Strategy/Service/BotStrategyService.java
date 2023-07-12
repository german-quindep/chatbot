package com.example.chatbot.TelegramBot.Strategy.Service;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.TelegramBot.Model.ResponseBot;
import com.example.chatbot.TelegramBot.Strategy.BotStrategyRegex;
import com.example.chatbot.TelegramBot.Strategy.IBotStrategy;

import jakarta.annotation.PostConstruct;

@Service
public class BotStrategyService {
    @Autowired
    private List<IBotStrategy> robotStrategies;
    private Map<BotStrategyRegex, IBotStrategy> map;

    @PostConstruct
    public void setup() {
        this.map = new HashMap<>();
        robotStrategies.forEach(robotStrategies -> map.put(robotStrategies.getTypeBot(), robotStrategies));
    }

    public ResponseBot executeAlgoritmo(BotStrategyRegex robotType, String numero) {
        return this.map.get(robotType).executeAlgoritmo(numero);
    }
}
