package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.Adresse;
import de.pathologie_hh_west.model.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by VaniR on 12.07.2017.
 */
public class PatientAttributAuswahl {
    private Patient patient;

    public PatientAttributAuswahl(String zellenWert, PatientModelAttribute attributName, Patient patient) {
        if (patient.getAdresse() == null) {
            patient.setAdresse(new Adresse());
        }
        switch (attributName) {
            case VORNAME:
                patient.setVorname(zellenWert);
                break;
            case NACHNAME:
                patient.setNachname(zellenWert);
                break;
            case ALTERNATIVNAME:
                patient.setAlternativName(zellenWert);
                break;
            case STRASSE:
                patient.getAdresse().setStrasse(zellenWert);
                break;
            case HAUSNUMMER:
                patient.getAdresse().setHausnummer(zellenWert);
                break;
            case PLZ:
                patient.getAdresse().setPlz(zellenWert);
                break;
            case ORT:
                patient.getAdresse().setOrt(zellenWert);
                break;
            case LAND:
                patient.getAdresse().setLand(zellenWert);
                break;
            default:
                throw new IllegalArgumentException(attributName + " sollte keine Zeichenkette sein");

        }
        this.patient = patient;
    }

    public PatientAttributAuswahl(BigDecimal zellenWert, PatientModelAttribute attributName, Patient patient) {
        switch (attributName) {
            case PLZ:
                patient.getAdresse().setPlz(zellenWert.setScale(0, BigDecimal.ROUND_HALF_UP).toString());
                break;
            case HAUSNUMMER:
                patient.getAdresse().setHausnummer(zellenWert.setScale(0, BigDecimal.ROUND_HALF_UP).toString());
                break;
            default:
                throw new IllegalArgumentException(attributName + " sollte keine Zahl sein");
        }
        this.patient = patient;
    }

    public PatientAttributAuswahl(LocalDate zellenWert, PatientModelAttribute attributName, Patient patient) {
        switch (attributName) {
            case GEBURTSDATUM:
                patient.setGeburtsDatum(zellenWert);
                break;
            default:
                throw new IllegalArgumentException(attributName + " sollte kein Datum sein");
        }
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }
}
