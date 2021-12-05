package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_status")
@Table(name = "iem_user", schema = "public")
public abstract class User {
    @Id
    @Column(name = "id_user")
    private String id = UUID.randomUUID().toString();

    private String lastName;
    private String firstName;
    private String email;

    @OneToOne (mappedBy = "user")
    private Access access;

    public User() {
    }

    public String getId() {
        return id;
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

    @Transient
    public String getStatus() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //    public Access getAccess() {
//        return access;
//    }
//
//    public void setAccess(Access access) {
//        this.access = access;
//    }
}
