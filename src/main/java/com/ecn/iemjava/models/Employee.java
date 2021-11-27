package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("employee")
public class Employee extends User{

    @Transient
    private List<Activity> activities;

    @Transient
    private List<Form> forms;

    public Employee() {

    }
}
