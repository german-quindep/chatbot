package com.example.chatbot.Otp.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_otp")
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private boolean status;
    @CreationTimestamp
    private LocalDateTime created;
    private LocalDateTime init_token;
    private LocalDateTime finish_token;
    @UpdateTimestamp
    private LocalDateTime updated;

    public Otp(Long id, String codigo, boolean status, LocalDateTime created, LocalDateTime init_token,
            LocalDateTime finish_token, LocalDateTime updated) {
        this.id = id;
        this.codigo = codigo;
        this.status = status;
        this.created = created;
        this.init_token = init_token;
        this.finish_token = finish_token;
        this.updated = updated;
    }

    public Otp() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getInit_token() {
        return init_token;
    }

    public void setInit_token(LocalDateTime init_token) {
        this.init_token = init_token;
    }

    public LocalDateTime getFinish_token() {
        return finish_token;
    }

    public void setFinish_token(LocalDateTime finish_token) {
        this.finish_token = finish_token;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

}
