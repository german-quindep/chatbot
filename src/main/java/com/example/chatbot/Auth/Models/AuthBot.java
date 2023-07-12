package com.example.chatbot.Auth.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "auth_bot")
@Data
public class AuthBot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_auth;
    private String chatId;
    @CreationTimestamp
    private LocalDateTime init_token;
    private LocalDateTime finish_token;

    public LocalDateTime sumGetTime() {
        return LocalDateTime.now().plusMinutes(10);
    }
}
