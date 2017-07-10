package de.pathologie_hh_west.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by VaniR on 10.07.2017.
 */
@Embeddable
public class FallID implements Serializable {

    @Embedded
    private ENummer eNummer;
    @Enumerated(EnumType.STRING)
    private BefundTyp befundTyp;
    @Column(name = "fall_index")
    private Integer index;

    public FallID() {
    }

    public FallID(ENummer eNummer) {
        this.eNummer = eNummer;
    }

    public ENummer geteNummer() {
        return eNummer;
    }

    public void seteNummer(ENummer eNummer) {
        //TODO Hurensohn
        this.eNummer = eNummer;
    }

    public BefundTyp getBefundTyp() {
        return befundTyp;
    }

    public void setBefundTyp(BefundTyp befundTyp) {
        this.befundTyp = befundTyp;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
