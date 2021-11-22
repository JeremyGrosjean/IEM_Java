package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "intermission_status")
public class IntermissionStatus {

    @Id
    @ManyToOne
    @JoinColumn(name = "idIntermission")
    private Intermission intermission;

    private String status;

}
