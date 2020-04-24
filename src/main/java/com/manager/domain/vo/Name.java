package com.manager.domain.vo;

import javax.persistence.Embeddable;

@Embeddable
public class Name {

    private String name;

    public Name() {
    }

    public Name(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    public String get() {
        return name;
    }
}
