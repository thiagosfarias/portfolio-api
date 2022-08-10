package com.thiago.br.portfolioapi.repository;

import com.thiago.br.portfolioapi.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByTitleContaining(String title);
}
