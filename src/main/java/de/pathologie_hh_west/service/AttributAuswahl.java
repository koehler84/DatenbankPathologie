package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by VaniR on 12.07.2017.
 */
public class AttributAuswahl {
    private Patient patient;

    public AttributAuswahl(String zellenWert, String attributName, Patient patient) {
        switch (attributName) {
            case "Vorname":
                patient.setVorname(attributName);
                break;
            case "Nachname":
                patient.setNachname(attributName);
                break;
            case "altName":
                patient.setAlternativName(attributName);
                break;

        }
        this.patient = patient;
    }

    public AttributAuswahl(BigDecimal zellenWert, String attributName, Patient patient) {
        this.patient = patient;
    }

    public AttributAuswahl(LocalDate zellenWert, String attributName, Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }
}
