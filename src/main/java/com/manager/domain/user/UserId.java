package com.manager.domain.user;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UserId implements Serializable {

    @AttributeOverride(name = "id", column = @Column(name = "id"))
    @SequenceGenerator(name = "SQ_ACCOUNT_GEN", sequenceName = "ACCOUNT_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACCOUNT_GEN")
    private Long id;

    public UserId(Long id) {
        this.id = id;
    }

    public Long get() {
        return this.id;
    }
}
