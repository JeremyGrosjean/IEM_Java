package com.ecn.iemjava.models;

import javax.persistence.*;

@Entity
@Table(name = "user_status")
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_status")
    private Integer id;

    @Column(name = "user_status")
    private String userStatus;

    public UserStatus() {
    }
}
