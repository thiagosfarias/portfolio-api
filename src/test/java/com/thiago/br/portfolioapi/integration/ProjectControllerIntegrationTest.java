package com.thiago.br.portfolioapi.integration;

import com.thiago.br.portfolioapi.controller.ProjectController;
import com.thiago.br.portfolioapi.entity.Project;
import com.thiago.br.portfolioapi.service.ProjectServiceImpl;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerIntegrationTest {
    @InjectMocks
    private ProjectController controller;
    @Mock
    private ProjectServiceImpl service;

    private MockMvc mockMvc;

    private Project project;
    private List<Project> projectList;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        project = Project.builder().id(1L).title("Teste Project")
                .description("Description Test")
                .postedAt(LocalDate.now())
                .build();
        projectList = new ArrayList<>();
        projectList.add(project);
    }

    @Test
    public void mustGetStatus200FromGettingAllTheProjects() throws Exception {
        when(service.getProjects()).thenReturn(projectList);

        mockMvc.perform(get("/projects")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
