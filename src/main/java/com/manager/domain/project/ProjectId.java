package com.manager.domain.project;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProjectId implements Serializable {

    @Column(name = "id")
    private Long id;

    public ProjectId() {}

    public ProjectId(Long id) {
        this.id = id;
    }

    public Long get() {
        return id;
    }
}
