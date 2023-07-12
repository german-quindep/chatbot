package com.example.chatbot.GeneratedPdf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chatbot.GeneratedPdf.Dto.ConsultPdfUSer;
import com.example.chatbot.GeneratedPdf.Entity.PdfUser;
import com.example.chatbot.Shared.Querys.QuerysSql;

public interface PdfUserRepository extends JpaRepository<PdfUser, Long> {
    @Query(value = QuerysSql.QUERY_PDF_USER, nativeQuery = true)
    public PdfUser getPdfUser(@Param("consult") ConsultPdfUSer consult);

}
