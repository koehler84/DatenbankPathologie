package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by VaniR on 12.07.2017.
 */
public class AttributAuswahl {
    private Patient.PatientBuilder patient;

    public AttributAuswahl(String zellenWert, ModelAttribute attributName, Patient.PatientBuilder patient) {
        switch (attributName) {
            case VORNAME:
                patient.vorname(zellenWert);
                break;
            case NACHNAME:
                patient.nachname(zellenWert);
                break;
            case ALTERNATIVNAME:
                patient.alternativName(zellenWert);
                break;
            case STRASSE:
                patient.strasse(zellenWert);
                break;
            case HAUSNUMMER:
                patient.hausnummer(zellenWert);
                break;
            case PLZ:
                patient.plz(zellenWert);
                break;
            case ORT:
                patient.ort(zellenWert);
                break;
            case LAND:
                patient.land(zellenWert);
                break;
            default:
                throw new IllegalArgumentException(attributName + " sollte keine Zeichenkette sein");

        }
        this.patient = patient;
    }

    public AttributAuswahl(BigDecimal zellenWert, ModelAttribute attributName, Patient.PatientBuilder patient) {
        switch (attributName) {
            case PLZ:
                patient.plz(zellenWert.setScale(0, BigDecimal.ROUND_HALF_UP).toString());
                break;
            case HAUSNUMMER:
                patient.hausnummer(zellenWert.setScale(0, BigDecimal.ROUND_HALF_UP).toString());
                break;
            default:
                throw new IllegalArgumentException(attributName + " sollte keine Zahl sein");
        }
        this.patient = patient;
    }

    public AttributAuswahl(LocalDate zellenWert, ModelAttribute attributName, Patient.PatientBuilder patient) {
        switch (attributName) {
            case GEBURTSDATUM:
                patient.geburtsDatum(zellenWert);
                break;
            default:
                throw new IllegalArgumentException(attributName + " sollte kein Datum sein");
        }
        this.patient = patient;
    }

    public Patient.PatientBuilder getPatient() {
        return patient;
    }
}
