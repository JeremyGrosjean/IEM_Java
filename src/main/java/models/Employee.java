package models;

import javax.persistence.OneToMany;
import java.util.List;

public class Employee extends User{

    @OneToMany(mappedBy = "employee")
    private List<Activity> activities;

    @OneToMany(mappedBy = "employee")
    private List<Form> forms;

    // OneToMany avec intermission ?????


    private UserStatus status;

    public Employee() {

    }
}
