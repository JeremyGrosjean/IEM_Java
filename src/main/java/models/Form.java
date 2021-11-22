package models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToOne
    @JoinColumn(name = "idFormStatus")
    private FormStatus formStatus;

    @Transient //ou OneToMany ?
    List<Question> questionsList;
}
