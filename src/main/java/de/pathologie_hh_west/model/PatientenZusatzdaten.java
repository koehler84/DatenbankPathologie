package de.pathologie_hh_west.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by VaniR on 11.07.2017.
 */
@Entity
public class PatientenZusatzdaten {
    @Id
    private String pseudonym;
    @Embedded
    private Exprimage exprimage;
    @Embedded
    private EE2015 ee2015;
    @Embedded
    private EE2011 ee2011;

    public PatientenZusatzdaten() {
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }
}
