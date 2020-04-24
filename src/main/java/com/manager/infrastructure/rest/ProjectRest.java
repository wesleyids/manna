package com.manager.infrastructure.rest;

import com.manager.business.ProjectBusiness;
import com.manager.domain.project.ProjectId;
import com.manager.domain.project.command.CreateProjectCommand;
import com.manager.domain.project.command.UpdateProjectCommand;
import com.manager.domain.project.query.ProjectQueryRequest;
import com.manager.domain.project.query.ProjectResponse;
import com.manager.domain.project.query.RemoveProjectRequest;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectRest {

    @Autowired
    private ProjectBusiness projectBusiness;

    @PostMapping
    public ResponseEntity save(@RequestBody CreateProjectCommand command) throws URISyntaxException {
        projectBusiness.save(command);
        return ResponseEntity.ok("");
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UpdateProjectCommand command) {
        projectBusiness.update(command);
        return ResponseEntity.ok("");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> get(@PathVariable("id") Long id) throws NotFoundException {
        ProjectResponse response = projectBusiness.find(new ProjectId(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@RequestBody RemoveProjectRequest request) {
        projectBusiness.remove(request);
        return ResponseEntity.ok("");
    }

    @PostMapping("/search")
    public ResponseEntity<List<ProjectResponse>> findAll(ProjectQueryRequest request) {
        List<ProjectResponse> response = projectBusiness.findAll(request);
        return new ResponseEntity<List<ProjectResponse>>(response, HttpStatus.OK);
    }


}
