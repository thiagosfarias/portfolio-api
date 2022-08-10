package com.thiago.br.portfolioapi.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectDTO {
    private String title;
    private String description;
}
