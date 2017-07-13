package de.pathologie_hh_west.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by VaniR on 10.07.2017.
 */
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"geburtsDatum", "vorname", "nachname"})
)
public class Patient {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "vorname")
    private String vorname;
    @Column(name = "nachname")
    private String nachname;
    private String alternativName;
    @Column(name = "geburtsDatum")
    private LocalDate geburtsDatum;
    @Embedded
    private Adresse adresse;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientID", referencedColumnName = "ID", nullable = false)
    private Set<Fall> faelle;
    @OneToOne(fetch = FetchType.LAZY)
    private PatientenZusatzdaten patientenZusatzdaten;

    private Patient(PatientBuilder builder) {
        this.vorname = builder.vorname;
        this.nachname = builder.nachname;
        this.geburtsDatum = builder.geburtsDatum;
        this.alternativName = builder.alternativName;
        this.adresse = builder.adresse;
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAlternativName() {
        return alternativName;
    }

    public void setAlternativName(String alternativName) {
        this.alternativName = alternativName;
    }

    public LocalDate getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(LocalDate geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Fall> getFaelle() {
        return faelle;
    }

    public void setFaelle(Set<Fall> faelle) {
        this.faelle = faelle;
    }

    public PatientenZusatzdaten getPatientenZusatzdaten() {
        return patientenZusatzdaten;
    }

    public void setPatientenZusatzdaten(PatientenZusatzdaten patientenZusatzdaten) {
        this.patientenZusatzdaten = patientenZusatzdaten;
    }

    public static class PatientBuilder {
        private String vorname;
        private String nachname;
        private LocalDate geburtsDatum;
        private String alternativName;
        private Adresse adresse;

        public PatientBuilder() {
        }

        public PatientBuilder vorname(String vorname) {
            this.vorname = vorname;
            return this;
        }

        public PatientBuilder nachname(String nachname) {
            this.nachname = nachname;
            return this;
        }

        public PatientBuilder geburtsDatum(LocalDate geburtsdatum) {
            this.geburtsDatum = geburtsdatum;
            return this;
        }

        public PatientBuilder alternativName(String alternativName) {
            this.alternativName = alternativName;
            return this;
        }

        public PatientBuilder strasse(String strasse) {
            if (this.adresse == null) {
                this.adresse = new Adresse();
            }
            this.adresse.setStrasse(strasse);
            return this;
        }

        public PatientBuilder hausnummer(String hausnummer) {
            if (this.adresse == null) {
                this.adresse = new Adresse();
            }
            this.adresse.setHausnummer(hausnummer);
            return this;
        }

        public PatientBuilder plz(String plz) {
            if (this.adresse == null) {
                this.adresse = new Adresse();
            }
            this.adresse.setPlz(plz);
            return this;
        }

        public PatientBuilder ort(String ort) {
            if (this.adresse == null) {
                this.adresse = new Adresse();
            }
            this.adresse.setOrt(ort);
            return this;
        }

        public PatientBuilder land(String land) {
            if (this.adresse == null) {
                this.adresse = new Adresse();
            }
            this.adresse.setLand(land);
            return this;
        }

        public PatientBuilder adresse(Adresse adresse) {
            this.adresse = adresse;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }

    }
}
