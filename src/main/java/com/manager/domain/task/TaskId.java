package com.manager.domain.task;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class TaskId implements Serializable {

    @Column(name = "id")
    private Long id;

    public TaskId() {
    }

    public TaskId(Long id) {
        this.id = id;
    }

    public Long get() {
        return id;
    }
}
