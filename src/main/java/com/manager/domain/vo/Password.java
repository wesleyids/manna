package com.manager.domain.vo;

import javax.persistence.Embeddable;

@Embeddable
public class Password {

    private String password;

    public Password(String password) {
        if (password == null) {
            throw new NullPointerException();
        }
        this.password = password;
    }

    public String get() {
        return password;
    }

}
