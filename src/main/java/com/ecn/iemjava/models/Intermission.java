package com.ecn.iemjava.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "intermission")
public class Intermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_intermission")
    private Integer id;

    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
