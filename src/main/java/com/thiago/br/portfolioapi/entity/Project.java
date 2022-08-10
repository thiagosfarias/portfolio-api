package com.thiago.br.portfolioapi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "posted_at", columnDefinition = "DATE")
    private LocalDate postedAt;
    @Column(name = "updated_at", columnDefinition = "DATE")
    private LocalDate updatedAt;
}
