package models;

import javax.persistence.*;

@Entity(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Integer id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "id_form")
    private Form form;


    @ManyToOne
    @JoinColumn(name = "id_answer")
    private Answer answer;

    public Question() {
    }
}
