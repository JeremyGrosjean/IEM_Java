package com.ecn.iemjava.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @Column(name = "id_activity")
    private String id = UUID.randomUUID().toString();

    private String title;
    private String content;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Employee employee;

    private String period;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Activity() {
    }
}
