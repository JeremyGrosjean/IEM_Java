package com.ecn.iemjava.models;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Integer id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "id_form")
    private Form form;

    @OneToOne(mappedBy = "question")
    private FormQuestion formQuestion;

    @OneToOne
    @JoinColumn(name = "id_answer")
    private Answer answer;

    public Question() {
    }
}
