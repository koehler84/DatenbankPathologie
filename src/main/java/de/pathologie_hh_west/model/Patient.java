package de.pathologie_hh_west.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by VaniR on 10.07.2017.
 */
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"geburtsDatum", "vorname", "nachname"})
)
//@Transactional(isolation = Isolation.SERIALIZABLE)
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
    @OneToOne(cascade = CascadeType.ALL)
    private PatientenZusatzdaten patientenZusatzdaten;

    public Patient() {
        this.adresse = new Adresse();
        this.patientenZusatzdaten = new PatientenZusatzdaten();
        this.faelle = new HashSet<Fall>();
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

    private Fall getFallByID(ENummer eNummer, BefundTyp befundTyp, Integer index) {
        for (Fall fall : this.getFaelle()) {
            if (fall.getFallID().geteNummer().getValue().equals(eNummer.getValue())
                    && fall.getFallID().getBefundTyp().equals(befundTyp)
                    ) {
                return fall;
            }
        }

        return null;
    }
}
