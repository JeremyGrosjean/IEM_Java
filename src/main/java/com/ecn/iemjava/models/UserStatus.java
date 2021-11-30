package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_status")
public class UserStatus {

    @Id
    @Column(name = "id_user_status")
    private String id = UUID.randomUUID().toString();

    @Column(name = "user_status")
    private String userStatus;

    public String getId() {
        return id;
    }

    public UserStatus() {
    }
}
