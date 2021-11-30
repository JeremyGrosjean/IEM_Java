package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_status")
public class UserStatus {

    @Id
    @Column(name = "id_user_status")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_status")
    private String userStatus;

    public Integer getId() {
        return id;
    }

    public UserStatus() {
    }
}
