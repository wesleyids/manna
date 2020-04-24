package com.manager.domain.user;

import com.manager.domain.enums.TypeAccountEnum;
import com.manager.domain.user.command.CreateUserCommand;
import com.manager.domain.vo.Created;
import com.manager.domain.vo.Email;
import com.manager.domain.vo.Name;
import com.manager.domain.vo.Password;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class User {

    @EmbeddedId
    private UserId id;

    @Embedded
    private Name name;

    @Embedded
    private Email email;

    @Embedded
    private Created created;

    public User(CreateUserCommand command){}

//    private Password password;
//    private TypeAccountEnum type;

    public void setId(UserId id) {
        this.id = id;
    }
}
