package com.thiago.br.portfolioapi.controller;

import com.thiago.br.portfolioapi.entity.Project;
import com.thiago.br.portfolioapi.entity.dto.ProjectDTO;
import com.thiago.br.portfolioapi.service.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(){
       List<Project> projects = service.getProjects();
       if(projects.isEmpty()) return new ResponseEntity<>(projects, HttpStatus.NOT_FOUND);
       return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Project> findByTitle(@PathVariable("title") String title){
        return new ResponseEntity<>(service.findByTitle(title), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> add(@RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(service.add(projectDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable("id") Long id,
                                          @RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(service.update(id, projectDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
