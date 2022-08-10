package com.thiago.br.portfolioapi.controller;

import com.thiago.br.portfolioapi.entity.Project;
import com.thiago.br.portfolioapi.entity.dto.ProjectDTO;
import com.thiago.br.portfolioapi.service.ProjectService;
import net.bytebuddy.asm.Advice;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectsControllerTest {
    @InjectMocks
    private ProjectController controller;
    @Mock
    private ProjectService service;

    private Project project;

    private List<Project> projectList;

    @Before
    public void setUp(){
        project = Project.builder()
                .id(1L)
                .title("Teste Project")
                .description("Teste Description")
                .postedAt(LocalDate.now())
                .build();

        projectList = new ArrayList<>();
        projectList.add(project);

    }

    @Test
    public void mustReturnAnEmptyListOfProjects(){
        when(service.getProjects())
                .thenReturn(Collections.emptyList());

        ResponseEntity<List<Project>> response = controller.getProjects();

        List<Project> projects = response.getBody();

        assertTrue(projects.isEmpty());
    }

    @Test
    public void mustReturnAllProjects(){
        when(service.getProjects()).thenReturn(projectList);

        ResponseEntity<List<Project>> response = controller.getProjects();

        List<Project> projects = response.getBody();

        assertFalse(projects.isEmpty());
    }

    @Test
    public void mustReturnAnProjectByHisTitle(){
        String title = "Teste Project";

        when(service.findByTitle(title)).thenReturn(project);

        ResponseEntity<Project> response = controller.findByTitle(title);

        Project projectRes = response.getBody();

        assertTrue(title.equalsIgnoreCase(projectRes.getTitle()));
    }

    @Test
    public void mustAddANewProjectWithSucess(){
        ProjectDTO projectDTO = ProjectDTO.builder().title("teste")
                .description("teste")
                .build();

        when(service.add(projectDTO)).thenReturn(Project.builder()
                        .id(1L)
                        .title(projectDTO.getTitle())
                        .description(projectDTO.getDescription())
                        .postedAt(LocalDate.now())
                .build());

        ResponseEntity<Project> response = controller.add(projectDTO);

        Project project = response.getBody();

        assertNotNull(project);
    }

    @Test
    public void mustUpdateAProjectWithSucess(){

    }

    @Test
    public void mustDeleteAProjectWithSucess(){

    }
}
