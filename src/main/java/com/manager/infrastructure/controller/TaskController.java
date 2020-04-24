package com.manager.infrastructure.controller;

import com.manager.business.PriorityBusiness;
import com.manager.business.ProjectBusiness;
import com.manager.constants.Mapping;
import com.manager.constants.Message;
import com.manager.domain.project.query.ProjectQueryRequest;
import com.manager.domain.project.query.ProjectResponse;
import com.manager.domain.task.command.CreateTaskCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private PriorityBusiness priorityBusiness;

    @Autowired
    private ProjectBusiness projectBusiness;

    @GetMapping(value = Mapping.TASK)
    public String index(Model model) {
        return "task/index";
    }

    @GetMapping(value = Mapping.TASK_ADD)
    public ModelAndView add(CreateTaskCommand task) {

        final int LIMIT = 10;

        List<String> priorities = priorityBusiness.getAll();
        List<ProjectResponse> projects = projectBusiness.findAll(new ProjectQueryRequest(LIMIT));

        ModelAndView mv = new ModelAndView("task/add");
        mv.addObject(Message.PARAM_TASK, task);
        mv.addObject(Message.PARAM_PRIORITIES, priorities);
        mv.addObject(Message.PARAM_PROJECTS, projects);
        return mv;
    }

    @PostMapping(value = Mapping.TASK_SAVE)
    public ModelAndView save(@Valid CreateTaskCommand task, BindingResult result) {

        if(result.hasErrors()) {
            return add(task);
        }

        return null;
    }

}
