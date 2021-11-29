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

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public FormQuestion getFormQuestion() {
        return formQuestion;
    }

    public void setFormQuestion(FormQuestion formQuestion) {
        this.formQuestion = formQuestion;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
