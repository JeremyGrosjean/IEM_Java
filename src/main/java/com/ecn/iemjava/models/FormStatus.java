package com.ecn.iemjava.models;

import javax.persistence.*;

@Entity
@Table(name = "form_status")
public class FormStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form_status")
    private Integer id;

    @Column(name = "form_status")
    private boolean formStatus;



    public FormStatus() {
    }

    public Integer getId() {
        return id;
    }

    public boolean isFormStatus() {
        return formStatus;
    }

    public void setFormStatus(boolean formStatus) {
        this.formStatus = formStatus;
    }
}
