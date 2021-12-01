package com.ecn.iemjava.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User{

    public Admin() {
    }

}
