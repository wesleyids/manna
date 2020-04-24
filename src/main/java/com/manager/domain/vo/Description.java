package com.manager.domain.vo;

import javax.persistence.Embeddable;

@Embeddable
public class Description {

    private String description;

    public Description() {
    }

    public Description(String description) {
        if (description == null) {
            throw new NullPointerException();
        }
        this.description = description;
    }

    public String get() {
        return this.description;
    }
}
