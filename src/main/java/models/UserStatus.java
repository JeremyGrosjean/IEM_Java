package models;

import javax.persistence.*;

@Entity(name = "user_status")
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_status")
    private Integer id;

    @Column(name = "user_status")
    private String userStatus;

    public UserStatus() {
    }
}
