package models;

import javax.persistence.*;

@Entity(name = "user_status")
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userStatus;


}
