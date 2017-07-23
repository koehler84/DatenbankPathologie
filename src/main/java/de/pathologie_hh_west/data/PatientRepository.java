package de.pathologie_hh_west.data;

import de.pathologie_hh_west.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Created by VaniR on 10.07.2017.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNachnameAndVornameAndGeburtsDatum(String nachname, String vorname, LocalDate geburtsDatum);         //TODO warum als return type nicht nur Patient oder Optional<Patient>? ist ja unique. hab ich auch getestet -eike

}
