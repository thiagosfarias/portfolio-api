package com.thiago.br.portfolioapi.service;

import com.thiago.br.portfolioapi.entity.Education;
import com.thiago.br.portfolioapi.entity.dto.EducationDTO;
import com.thiago.br.portfolioapi.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService{
    private final EducationRepository repository;

    @Override
    public List<Education> findAll() {
        return repository.findAll();
    }

    @Override
    public Education add(EducationDTO educationDTO) {
        Education education = Education.builder()
                .institute(educationDTO.getInstitute())
                .classTitle(educationDTO.getClassTitle())
                .startedAt(educationDTO.getStartedAt())
                .finisedAt(Objects.isNull(educationDTO.getStartedAt()) ?
                            LocalDate.now() : educationDTO.getFinishedAt())
                .build();

        return repository.save(education);
    }

    @Override
    public Education update(Long id, EducationDTO educationDTO) {
        Optional<Education> education = repository.findById(id);

        education.ifPresent(
                educationOpt -> {
                    educationOpt.setClassTitle(educationDTO.getClassTitle());
                    educationOpt.setInstitute(educationDTO.getInstitute());
                    educationOpt.setStartedAt(educationDTO.getStartedAt());
                    educationOpt.setFinisedAt(educationDTO.getFinishedAt());

                    repository.save(education.get());
                });

        return education.orElseGet(Education::new);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
