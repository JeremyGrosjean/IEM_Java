package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "form_status")
public class FormStatus {

    @Id
    @Column(name = "id_form_status")
    private String id = UUID.randomUUID().toString();

    @Column(name = "form_status")
    private boolean formStatus;



    public FormStatus() {
    }

    public String getId() {
        return id;
    }

    public boolean isFormStatus() {
        return formStatus;
    }

    public void setFormStatus(boolean formStatus) {
        this.formStatus = formStatus;
    }
}
