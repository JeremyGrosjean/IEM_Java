package com.ecn.iemjava.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "intermission")
public class Intermission {

    @Id
    @Column(name = "id_intermission")
    private String id = UUID.randomUUID().toString();

    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_intermission_status")
    private IntermissionStatus intermissionStatus;

    public Intermission() {
    }

    public String getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public IntermissionStatus getIntermissionStatus() {
        return intermissionStatus;
    }

    public void setIntermissionStatus(IntermissionStatus intermissionStatus) {
        this.intermissionStatus = intermissionStatus;
    }
}
