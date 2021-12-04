package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "form_question")
public class FormQuestion {

    @Id
    @Column(name = "id_form_question")
    private String id = UUID.randomUUID().toString();

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

    public String getId() {
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
