package com.manager.domain.task.command;

public class CreateTaskCommand {

    private String title;
    private String description;
    private Long projectId;
    private String status;
    private String priority;
    private String estimatedTime;
    private Long responsibleId;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public Long getResponsibleId() {
        return responsibleId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public void setResponsibleId(Long responsibleId) {
        this.responsibleId = responsibleId;
    }
}
