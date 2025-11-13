package com.example.gamestore.services;

import com.example.gamestore.model.Company;
import com.example.gamestore.repositories.CompanyRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepo companyRepo;

    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public List<Company> getAllCompanies() {
        return this.companyRepo.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return this.companyRepo.findById(id);
    }

    public Company saveCompany(Company company) {
        return (Company)this.companyRepo.save(company);
    }

    public void deleteCompany(Long id) {
        this.companyRepo.deleteById(id);
    }
}