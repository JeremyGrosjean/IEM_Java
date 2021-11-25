package models;

import javax.persistence.*;

@Entity
@Table(name = "access")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_access")
    private Integer id;

    private String account;
    private String password;

    @OneToOne(mappedBy = "access")
    private User user;

    public Access() {
    }
}
