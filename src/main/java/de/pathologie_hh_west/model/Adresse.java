package de.pathologie_hh_west.model;

import javax.persistence.Embeddable;

/**
 * Created by VaniR on 10.07.2017.
 */
@Embeddable
public class Adresse {
    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
    private String land;

    private Adresse(AdressenBuilder builder) {
        this.strasse = builder.strasse;
        this.hausnummer = builder.hausnummer;
        this.plz = builder.plz;
        this.ort = builder.ort;
        this.land = builder.land;
    }
    
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

    public static class AdressenBuilder {
        private String strasse;
        private String hausnummer;
        private String plz;
        private String ort;
        private String land;

        public AdressenBuilder() {
        }

        public AdressenBuilder strasse(String strasse) {
            this.strasse = strasse;
            return this;
        }

        public AdressenBuilder hausnummer(String hausnummer) {
            this.hausnummer = hausnummer;
            return this;
        }

        public AdressenBuilder plz(String plz) {
            this.plz = plz;
            return this;
        }

        public AdressenBuilder ort(String ort) {
            this.ort = ort;
            return this;
        }

        public AdressenBuilder land(String land) {
            this.land = land;
            return this;
        }
    }
}
