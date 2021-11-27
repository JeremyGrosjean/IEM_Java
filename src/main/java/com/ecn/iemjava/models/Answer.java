package com.ecn.iemjava.models;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_answer")
    private Integer id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "id_form_question")
    private FormQuestion formQuestion;

    @OneToOne(mappedBy = "answer")
    private Question question;

    public Answer() {
    }
}
