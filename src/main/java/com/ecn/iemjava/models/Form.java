package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "form")
public class Form {

    @Id
    @Column(name = "id_form")
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_form_status")
    private FormStatus formStatus;

    public Form() {
    }

    public String getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public FormStatus getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(FormStatus formStatus) {
        this.formStatus = formStatus;
    }


}
