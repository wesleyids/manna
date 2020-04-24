package com.manager.domain.project.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class CreateProjectCommand {

    @Max(value = 50)
    @NotBlank
    private String name;

    @Max(value = 250)
    @NotBlank
    private String description;

    @Max(value = 4)
    @NotBlank
    private String prefix;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
