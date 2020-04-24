package com.manager.infrastructure.rest;

import com.manager.business.TaskBusiness;
import com.manager.domain.task.Task;
import com.manager.domain.task.command.CreateTaskCommand;
import com.manager.domain.task.query.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskRest {

    @Autowired
    private TaskBusiness taskBusiness;

    @PostMapping
    public ResponseEntity save(@RequestBody CreateTaskCommand command) throws URISyntaxException {
        taskBusiness.save(command);
        return ResponseEntity.created(new URI("/testeTask")).build();
    }

    @PutMapping
    public ResponseEntity<Task> update(@RequestBody Task task) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/project/{projectId}")
    public List<TaskResponse> getTasks(@PathVariable("projectId") Long projectId) {
//        List<Task> tasks = entityManager.createQuery(
//                "select t " +
//                        "from Task t " +
//                        "where t.project.id = :projectId", Task.class)
//                .setParameter( "projectId", projectId )
//                .getResultList();
//        return tasks;
        return this.taskBusiness.findAll(null);
    }
}
