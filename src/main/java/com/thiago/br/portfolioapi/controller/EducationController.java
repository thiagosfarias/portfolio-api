package com.thiago.br.portfolioapi.controller;

import com.thiago.br.portfolioapi.entity.Education;
import com.thiago.br.portfolioapi.entity.Project;
import com.thiago.br.portfolioapi.entity.dto.EducationDTO;
import com.thiago.br.portfolioapi.entity.dto.ProjectDTO;
import com.thiago.br.portfolioapi.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("education")
public class EducationController {

    private final EducationService service;

    @GetMapping
    public ResponseEntity<List<Education>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Education> add(@RequestBody EducationDTO educationDTO){
        return new ResponseEntity<>(service.add(educationDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> update(@PathVariable("id") Long id,
                                          @RequestBody EducationDTO educationDTO){
        return new ResponseEntity<>(service.update(id, educationDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
