package models;

import javax.persistence.*;

@Entity(name = "access")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAccess")
    private Integer id;

    private String account;
    private String password;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
}
