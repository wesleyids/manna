package com.manager.domain.project.command;

import java.util.Date;

public class UpdateProjectCommand {

    private String name;
    private String description;
    private String prefix;
    private Date created;

    public UpdateProjectCommand(String name, String description, String prefix, Date created) {
        this.name = name;
        this.description = description;
        this.prefix = prefix;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrefix() {
        return prefix;
    }

    public Date getCreated() {
        return created;
    }
}
