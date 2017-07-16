package de.pathologie_hh_west.model;

import javax.persistence.*;

/**
 * Created by VaniR on 11.07.2017.
 */
@Entity
public class PatientenZusatzdaten {
    @Id
    @GeneratedValue
    @Column(name = "dummy_id")
    private Long id;
    private String pseudonym;
    @Embedded
    private Exprimage exprimage;
    @Embedded
    private EE2015 ee2015;
    @Embedded
    private EE2011 ee2011;

    public PatientenZusatzdaten() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Exprimage getExprimage() {
        return exprimage;
    }

    public void setExprimage(Exprimage exprimage) {
        this.exprimage = exprimage;
    }

    public EE2015 getEe2015() {
        return ee2015;
    }

    public void setEe2015(EE2015 ee2015) {
        this.ee2015 = ee2015;
    }

    public EE2011 getEe2011() {
        return ee2011;
    }

    public void setEe2011(EE2011 ee2011) {
        this.ee2011 = ee2011;
    }

}
