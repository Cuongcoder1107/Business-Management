package org.example.employeemanagement.service;

import org.example.employeemanagement.entity.Province;
import org.example.employeemanagement.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    public List<Province> getAllProvince() {
        return provinceRepository.findAll();
    }
}
