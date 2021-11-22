package models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActivity")
    private Integer id;

    private String title;
    private String content;
    private Date date;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "period")
    private Period period;


}
