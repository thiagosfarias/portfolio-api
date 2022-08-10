package com.thiago.br.portfolioapi.repository;

import com.thiago.br.portfolioapi.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
