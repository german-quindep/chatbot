package com.example.chatbot.Auth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chatbot.Auth.DTO.ConsultAuthBot;
import com.example.chatbot.Auth.Models.AuthBot;
import com.example.chatbot.Shared.Querys.QuerysSql;

public interface AuthBotRepository extends JpaRepository<AuthBot, Long> {
    @Query(value = QuerysSql.QUERY_AUTH_BOT, nativeQuery = true)
    public AuthBot getBothAuth(@Param("consult") ConsultAuthBot consult);

}
