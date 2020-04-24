package com.manager.infrastructure.controller;

import com.manager.business.ProjectBusiness;
import com.manager.constants.Message;
import com.manager.constants.Mapping;
import com.manager.domain.project.command.CreateProjectCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ProjectController {

    @Autowired
    private ProjectBusiness projectBusiness;

    @GetMapping(value = Mapping.PROJECT)
    public String index(Model model) {
        return "project/index";
    }

    @GetMapping(value = Mapping.PROJECT_ADD)
    public ModelAndView add(CreateProjectCommand project) {
        ModelAndView mv = new ModelAndView("project/add");
        mv.addObject("project", project);
        return mv;
    }

    @PostMapping(value = Mapping.PROJECT_SAVE)
    public ModelAndView save(@Valid CreateProjectCommand project, BindingResult result, ModelMap model) {

//        if (result.hasErrors()) {
//            return add(project);
//        }

        projectBusiness.save(project);

        model.addAttribute(Message.PARAM_MESSAGE, Message.DEFAULT_SAVE);
        return new ModelAndView("redirect:/", model);
    }

}
