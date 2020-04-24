package com.manager.infrastructure.controller;

import com.manager.business.ProjectBusiness;
import com.manager.domain.project.query.ProjectQueryRequest;
import com.manager.domain.project.query.ProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProjectBusiness projectBusiness;

    @GetMapping(value = "/")
    public ModelAndView index() {

        List<ProjectResponse> projects = projectBusiness.findAll(new ProjectQueryRequest());

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("projects", projects);
        return mv;
    }

}
