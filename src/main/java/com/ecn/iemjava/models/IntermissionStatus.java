package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "intermission_status")
public class IntermissionStatus {

    @Id
    @Column(name = "id_intermission_status")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean status;

    public IntermissionStatus() {
    }

    public Integer getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
