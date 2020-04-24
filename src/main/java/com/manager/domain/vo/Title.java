package com.manager.domain.vo;

import javax.persistence.Embeddable;

@Embeddable
public class Title {

    private String title;

    public Title() {
    }

    public Title(String title) {
        this.title = title;
    }

    public String get() {
        return title;
    }
}
