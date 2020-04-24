package com.manager.domain.vo;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class Started {

    private Date started;

    public Started() {
        this.started = new Date();
    }

    public Started(Date created) {
        this.started = created;
    }

    public Started get() {
        this.started = new Date();
        return this;
    }
}
