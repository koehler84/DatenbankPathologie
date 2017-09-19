package de.pathologie_hh_west.service;

import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void deletePatient(Patient patient) {
        if (patient.getGeburtsDatum() == null || patient.getNachname() == null || patient.getVorname() == null) {
            throw new IllegalArgumentException("Patient konnte nicht eindeutig identifiziert werden.");
        }
        patientRepository.delete(patient);
    }
}
