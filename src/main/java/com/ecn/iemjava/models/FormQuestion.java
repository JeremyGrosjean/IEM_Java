package com.ecn.iemjava.models;

import javax.persistence.*;

@Entity
@Table(name = "form_question")
public class FormQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form_question")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_form")
    private Form form;

    @OneToOne
    @JoinColumn(name = "id_question")
    private Question question;

    @OneToOne
    @JoinColumn(name = "id_answer")
    private Answer answer;

    public FormQuestion() {
    }

    public Integer getId() {
        return id;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
