package com.springback.sksbackend.service.Impl;

import com.springback.sksbackend.dto.CompanyDTO;
import com.springback.sksbackend.entity.Company;
import com.springback.sksbackend.exception.ResourceNotFoundException;
import com.springback.sksbackend.mapper.CompanyMapper;
import com.springback.sksbackend.repository.CompanyRepo;
import com.springback.sksbackend.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepo companyRepo;
    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {

        Company company = CompanyMapper.mapToCompany(companyDTO);
        Company savedCompany = companyRepo.save(company);
        return CompanyMapper.mapToCompanyDto(savedCompany);
    }

    @Override
    public CompanyDTO getCompanyById(Long companyId) {
        Company company = companyRepo.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Girilen id numaralı firma bulunamadı: " + companyId));
        return CompanyMapper.mapToCompanyDto(company);
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
         List<Company> companies = companyRepo.findAll();
         return companies.stream().map((company) -> CompanyMapper.mapToCompanyDto(company))
                 .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO updateCompany(Long companyId, CompanyDTO updatedCompany) {
        Company company = companyRepo.findById(companyId).orElseThrow(
                () -> new ResourceNotFoundException("Girilen id numaralı firma bulunamadı: " + companyId));

        company.setCompanyName(updatedCompany.getCompanyName());
        company.setTelNumber(updatedCompany.getTelNumber());
        company.setEmail(updatedCompany.getEmail());
        company.setTaxAdministration(updatedCompany.getTaxAdministration());
        company.setTaxNo(updatedCompany.getTaxNo());
        company.setAddress(updatedCompany.getAddress());

        Company updatedCompanyObject = companyRepo.save(company);

        return CompanyMapper.mapToCompanyDto(updatedCompanyObject);
    }

    @Override
    public void deleteCompany(Long companyId) {
        Company company = companyRepo.findById(companyId).orElseThrow(
            () -> new ResourceNotFoundException("Girilen id numaralı firma bulunamadı: " + companyId));

        companyRepo.deleteById(companyId);
        }
}

