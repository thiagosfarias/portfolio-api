package com.thiago.br.portfolioapi.service;

import com.thiago.br.portfolioapi.entity.Project;
import com.thiago.br.portfolioapi.entity.dto.ProjectDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProjectsService {
    List<Project> getProjects();

    Project findByTitle(String title);

    Project add(ProjectDTO projectDTO);

    Project update(Long id, ProjectDTO projectDTO);

    void delete(Long id);

}

