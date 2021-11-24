package models;

import javax.persistence.*;

@Entity
@Table(name = "iem_user")
public abstract class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    private String lastName;
    private String firstName;
    private String email;
    private String account;
    private String password;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
