package com.ecn.iemjava.models;

import javax.persistence.*;

@Entity
@Table(name = "form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_form_status")
    private FormStatus formStatus;

    public Form() {
    }

    public Integer getId() {
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
