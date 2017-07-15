package de.pathologie_hh_west.data;

import de.pathologie_hh_west.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by VaniR on 10.07.2017.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNachnameAndVornameAndGeburtsDatum(String nachname, String vorname, LocalDate geburtsDatum);
}
