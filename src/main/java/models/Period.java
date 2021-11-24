package models;

import javax.persistence.Entity;
import javax.persistence.Table;

// Je crois que le mapping de la table period ne fonctionne pas
@Entity
@Table(name = "period")
public enum Period {
    MATIN,
    APRÈSMIDI
}
