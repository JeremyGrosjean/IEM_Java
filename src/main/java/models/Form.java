package models;

import javax.persistence.*;

@Entity(name = "form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "id_form_status")
    private FormStatus formStatus;

    public Form() {
    }
}
