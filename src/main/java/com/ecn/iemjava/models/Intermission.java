package com.ecn.iemjava.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "intermission")
public class Intermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_intermission")
    private Integer id;

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

    public Integer getId() {
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
