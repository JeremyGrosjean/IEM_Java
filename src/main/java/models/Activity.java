package models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activity")
    private Integer id;

    private String title;
    private String content;
    private Date date;

    @ManyToOne
    @JoinColumn(name="id_user")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "period")
    private Period period;

    public Activity() {
    }
}
