package models;

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

    @OneToOne(mappedBy = "answer")//je suis pas sur de ca
    private Question question;

    public Answer() {
    }
}
