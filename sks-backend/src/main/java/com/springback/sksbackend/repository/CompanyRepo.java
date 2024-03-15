package com.springback.sksbackend.repository;


import com.springback.sksbackend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
}
