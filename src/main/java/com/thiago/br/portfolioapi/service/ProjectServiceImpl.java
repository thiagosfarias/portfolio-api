package com.thiago.br.portfolioapi.service;

import com.thiago.br.portfolioapi.entity.Project;
import com.thiago.br.portfolioapi.entity.dto.ProjectDTO;
import com.thiago.br.portfolioapi.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectsService{
    private final ProjectRepository repository;

    @Override
    public List<Project> getProjects() {
        return repository.findAll();
    }

    @Override
    public Project findByTitle(String title){
        return repository.findByTitleContaining(title);
    }

    @Override
    public Project add(ProjectDTO projectDTO) {
        Project project = Project.builder()
                .title(projectDTO.getTitle())
                .description(projectDTO.getDescription())
                .postedAt(LocalDate.now())
                .build();

        return repository.save(project);
    }

    @Override
    public Project update(Long id, ProjectDTO projectDTO) {
        Optional<Project> project = repository.findById(id);

         project.ifPresent(
                projectOpt -> {
                    projectOpt.setTitle(projectDTO.getTitle());
                    projectOpt.setDescription(projectDTO.getDescription());
                    projectOpt.setUpdatedAt(LocalDate.now());

                    repository.save(project.get());
                }
         );

         return project.orElseGet(Project::new);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
