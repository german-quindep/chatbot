package com.example.chatbot.Otp.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_otp")
@Data
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private boolean status;
    private String idChat;
    private String identificacion;
    @CreationTimestamp
    private LocalDateTime created;
    private LocalDateTime init_token;
    private LocalDateTime finish_token;
    @UpdateTimestamp
    private LocalDateTime updated;
}
