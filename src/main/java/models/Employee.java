package models;

import java.util.List;

public class Employee extends User{

    private List<Activity> activities;
    private List<Form> forms;
    private UserStatus status;

    public Employee() {

    }
}
