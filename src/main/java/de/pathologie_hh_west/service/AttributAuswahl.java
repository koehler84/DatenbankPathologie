package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by VaniR on 12.07.2017.
 */
public class AttributAuswahl {
    private Patient.PatientBuilder patient;

    public AttributAuswahl(String zellenWert, String attributName, Patient.PatientBuilder patient) {
        switch (attributName) {
            case "Vorname":
                patient.vorname(zellenWert);
                break;
            case "Nachname":
                patient.nachname(zellenWert);
                break;
            case "altName":
                patient.alternativName(zellenWert);
                break;
            case "Strasse":
                patient.strasse(zellenWert);
                break;
            case "Hausnummer":
                patient.hausnummer(zellenWert);
                break;
            case "PLZ":
                patient.plz(zellenWert);
                break;
            case "Ort":
                patient.ort(zellenWert);
                break;
            case "Land":
                patient.land(zellenWert);
                break;


        }
        this.patient = patient;
    }

    public AttributAuswahl(BigDecimal zellenWert, String attributName, Patient.PatientBuilder patient) {
        this.patient = patient;
    }

    public AttributAuswahl(LocalDate zellenWert, String attributName, Patient.PatientBuilder patient) {
        switch (attributName) {
            case "Geburtsdatum":
                patient.geburtsDatum(zellenWert);
                break;
        }
        this.patient = patient;
    }

    public Patient.PatientBuilder getPatient() {
        return patient;
    }
}
