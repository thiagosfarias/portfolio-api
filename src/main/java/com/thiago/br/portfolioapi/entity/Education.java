package com.thiago.br.portfolioapi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Education implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "started_at", columnDefinition = "DATE")
    private LocalDate startedAt;
    @Column(name = "finished_at", columnDefinition = "DATE")
    private LocalDate finisedAt;

    @Column(name = "institute")
    private String institute;

    @Column(name = "class_title")
    private String classTitle;
}
