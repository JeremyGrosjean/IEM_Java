package models;

import javax.persistence.Entity;

@Entity(name = "period")
public enum Period {
    MATIN,
    APRÈSMIDI
}
