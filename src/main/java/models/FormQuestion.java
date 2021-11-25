package models;

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

    public FormQuestion() {
    }
}
