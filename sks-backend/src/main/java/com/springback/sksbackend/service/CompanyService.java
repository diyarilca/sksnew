package com.springback.sksbackend.service;

import com.springback.sksbackend.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    CompanyDTO createCompany(CompanyDTO companyDTO);

    CompanyDTO getCompanyById(Long companyId);

    List<CompanyDTO> getAllCompanies();

    CompanyDTO updateCompany(Long companyId,CompanyDTO updatedCompany);

    void deleteCompany(Long companyId);
}
