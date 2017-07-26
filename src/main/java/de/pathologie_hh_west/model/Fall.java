package de.pathologie_hh_west.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * Created by VaniR on 10.07.2017.
 */
@Entity
public class Fall {
    @EmbeddedId
    private FallID fallID;
    @Column(length = 1000000)
    private String befundtext;
    @Embedded
    private Klassifikation klassifikation;

    public Fall() {
        this.fallID = new FallID();
        this.klassifikation = new Klassifikation();
    }

    public FallID getFallID() {
        return fallID;
    }

    public void setFallID(FallID fallID) {
        this.fallID = fallID;
    }

    public String getBefundtext() {
        return befundtext;
    }

    public void setBefundtext(String befundtext) {
        this.befundtext = befundtext;
    }

    public Klassifikation getKlassifikation() {
        return klassifikation;
    }

    public void setKlassifikation(Klassifikation klassifikation) {
        this.klassifikation = klassifikation;
    }

}
