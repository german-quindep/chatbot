package com.example.chatbot.BloqUser.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chatbot.BloqUser.Models.BloqUserModel;
import com.example.chatbot.Shared.Querys.QuerysSql;

public interface BloqUserRepository extends JpaRepository<BloqUserModel, Long> {
    @Query(value = QuerysSql.QUERY_BLOQ_USER, nativeQuery = true)
    public BloqUserModel getBloqUser(@Param("idChat") String idChat);

    @Query(value = QuerysSql.QUERY_INTENTOS_USER, nativeQuery = true)
    public BloqUserModel getIntentosUser(@Param("idChat") String idChat);

}
