package com.thiago.br.portfolioapi.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EducationDTO {
    private String institute;
    private String classTitle;
    private LocalDate startedAt;
    private LocalDate finishedAt;
}
