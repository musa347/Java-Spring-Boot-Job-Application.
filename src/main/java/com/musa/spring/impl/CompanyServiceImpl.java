package com.musa.spring.impl;

import com.musa.spring.entity.Company;
import com.musa.spring.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyUpdate = companyOptional.get();
            companyUpdate.setName(company.getName());
            companyUpdate.setDescription(companyUpdate.getDescription());
            companyUpdate.setJobs(companyUpdate.getJobs());
            companyRepository.save(companyUpdate);
            return true;
        } else {
            return false;
        }
    }
        public void createCompany(Company company) {
            companyRepository.save(company);
        }
        public boolean deleteCompanyById(Long id){
            if(companyRepository.existsById(id)){
                companyRepository.deleteById(id);
                return true;
            }else {
                return false;
            }
        }

        public Company getCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            return companyRepository.findById(id).orElse(null);
        }
        return null;
        }}
