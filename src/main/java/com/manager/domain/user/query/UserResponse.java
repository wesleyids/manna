package com.manager.domain.user.query;

import com.manager.domain.user.User;

import java.util.Date;

public class UserResponse {

    private Long id;
    private String email;
    private String name;
    private Date created;

    public static UserResponse of(User user) {
        return null;
    }
}
