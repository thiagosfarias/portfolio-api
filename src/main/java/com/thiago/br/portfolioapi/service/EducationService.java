package com.thiago.br.portfolioapi.service;

import com.thiago.br.portfolioapi.entity.Education;
import com.thiago.br.portfolioapi.entity.dto.EducationDTO;

import java.util.List;

public interface EducationService {
    List<Education> findAll();

    Education add(EducationDTO educationDTO);

    Education update(Long id, EducationDTO educationDTO);

    void delete(Long id);
}
