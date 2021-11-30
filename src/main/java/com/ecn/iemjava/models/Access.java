package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "access")
public class Access {

    @Id
    @Column(name = "id_access")
    private String id = UUID.randomUUID().toString();

    private String account;
    private String password;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Access() {
    }

    public String getId() {
        return id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
