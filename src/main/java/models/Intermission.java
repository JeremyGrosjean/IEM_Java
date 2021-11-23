package models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "intermission")
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
}
