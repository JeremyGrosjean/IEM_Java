package models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "intermission")
public class Intermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIntermission")
    private Integer id;

    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user; //user ou Employee ?

    @ManyToOne
    @JoinColumn(name = "idIntermissionStatus")
    private IntermissionStatus intermissionStatus;

}
