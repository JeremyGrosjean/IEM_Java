package com.ecn.iemjava.models;

import java.time.LocalDate;

public class EndIntermission {

    private String idEmployee;
    private LocalDate endDate;

    public String getIdEmployee() {
        return idEmployee;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
