package models;

import javax.persistence.*;

@Entity
@Table(name = "iem_user")
public abstract class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    private String lastName;
    private String firstName;
    private String email;

    @OneToOne
    @JoinColumn(name = "id_access")
    private Access access;

    //wtf Keskonfé avec ce userStatut
    @ManyToOne
    @JoinColumn(name = "idUserStatus")
    public UserStatus userStatus;

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
