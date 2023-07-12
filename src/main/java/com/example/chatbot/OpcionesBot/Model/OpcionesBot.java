package com.example.chatbot.OpcionesBot.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_tipo_op")
@Data
public class OpcionesBot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime created;
    private String tipo_solicitud;
    private String identificacion;

    public OpcionesBot(String identificacion, String tipo) {
        this.identificacion = identificacion;
        this.tipo_solicitud = tipo;
    }
}
