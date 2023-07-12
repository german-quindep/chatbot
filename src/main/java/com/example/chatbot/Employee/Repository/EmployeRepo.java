package com.example.chatbot.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chatbot.Employee.Model.Employee;
import com.example.chatbot.Shared.Querys.QuerysSql;
public interface EmployeRepo extends JpaRepository<Employee, Long> {
    @Query(value = QuerysSql.QUERY_EMPLOYE_SEARCH, nativeQuery = true)
    public Employee getIdentified(@Param("identified") String identified);
}
