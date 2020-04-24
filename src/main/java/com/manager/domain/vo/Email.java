package com.manager.domain.vo;

import javax.persistence.Embeddable;

@Embeddable
public class Email {

    private String email;

    public Email(String email) {
        if (email == null) {
            throw new NullPointerException();
        }
        this.email = email;
    }

    public String get() {
        return email;
    }
}
