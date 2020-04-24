package com.manager.domain.vo;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class Created {

    private Date created;

    public Created() {
        this.created = new Date();
    }

    public Created(Date created) {
        if (created == null) {
            created = new Date();
        }
        this.created = created;
    }

    public Created get() {
        this.created = new Date();
        return this;
    }
}
