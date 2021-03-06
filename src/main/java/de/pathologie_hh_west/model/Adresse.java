package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by VaniR on 10.07.2017.
 */
@Embeddable
public class Adresse implements Serializable {
    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
    private String land;

    public Adresse() {
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

}
