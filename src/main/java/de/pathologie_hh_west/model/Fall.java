package de.pathologie_hh_west.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * Created by VaniR on 10.07.2017.
 */
@Entity
public class Fall implements Serializable {
    @EmbeddedId
    private FallID fallID;
    @Column(length = 1000000)
    private String befundtext;
    @Embedded
    private Klassifikation klassifikation;
    private LocalDate EingangsDatum;
    private String Einsender;


    public Fall() {
        this.fallID = new FallID();
        this.klassifikation = new Klassifikation();
    }

    public LocalDate getEingangsDatum() {
        return EingangsDatum;
    }

    public void setEingangsDatum(LocalDate eingangsDatum) {
        EingangsDatum = eingangsDatum;
    }

    public String getEinsender() {
        return Einsender;
    }

    public void setEinsender(String einsender) {
        Einsender = einsender;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fall)) return false;

        Fall fall = (Fall) o;

        return getFallID().equals(fall.getFallID());
    }

    @Override
    public int hashCode() {
        return getFallID().hashCode();
    }
}
