package com.manager.domain.vo;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class Finished {

    private Date finished;

    public Finished() {
        this.finished = new Date();
    }

    public Finished(Date created) {
        this.finished = created;
    }

    public Finished get() {
        this.finished = new Date();
        return this;
    }
}
