package models;

import javax.persistence.*;

@Entity(name = "form_status")
public class FormStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form_status")
    private Integer id;

    @Column(name = "form_status")
    private boolean formStatus;

    public FormStatus() {
    }
}
