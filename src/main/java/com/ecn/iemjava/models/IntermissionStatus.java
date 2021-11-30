package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "intermission_status")
public class IntermissionStatus {

    @Id
    @Column(name = "id_intermission_status")
    private String id = UUID.randomUUID().toString();

    private boolean status;

    public IntermissionStatus() {
    }

    public String getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
