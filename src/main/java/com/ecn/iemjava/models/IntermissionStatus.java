package com.ecn.iemjava.models;

import javax.persistence.*;

@Entity
@Table(name = "intermission_status")
public class IntermissionStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_intermission_status")
    private Integer id;

    private boolean status;

    public IntermissionStatus() {
    }
}
