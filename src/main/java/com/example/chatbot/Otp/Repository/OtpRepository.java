package com.example.chatbot.Otp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chatbot.Otp.Dto.ConsultOtp;
import com.example.chatbot.Otp.Dto.ConsultOtpCedula;
import com.example.chatbot.Otp.Entity.Otp;
import com.example.chatbot.Shared.Querys.QuerysSql;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    @Query(value = QuerysSql.QUERY_OTP, nativeQuery = true)
    public Otp findByOtp(@Param("otp") ConsultOtp otp);

    @Query(value = QuerysSql.QUERY_OTP_CEDULA, nativeQuery = true)
    public Otp findOtpCedula(@Param("otp") ConsultOtpCedula otp);

    @Query(value = QuerysSql.QUERY_GET_CEDULA, nativeQuery = true)
    public Otp finCedulaGet(@Param("idChat") String idChat);

}
