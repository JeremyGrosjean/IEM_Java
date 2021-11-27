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

    @OneToOne(mappedBy = "form")
    private FormQuestion formQuestion;

    public Form() {
    }
}
