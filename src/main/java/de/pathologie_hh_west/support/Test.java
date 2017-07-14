package de.pathologie_hh_west.support;

import de.pathologie_hh_west.data.FallRepository;
import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by eike on 10.07.2017.
 */
@Component
public class Test implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private FallRepository fallRepository;
	@Override
	public void run(String... strings) throws Exception {
		Adresse adresse = new Adresse();
		Patient patient = new Patient();
		LocalDate date = LocalDate.now();
		Fall fall = new Fall();
		Fall fall1 = new Fall();
		
		FallID e4321 = new FallID(new ENummer("E4321"));
		e4321.setBefundTyp(BefundTyp.NACHBEFUND);
		e4321.setIndex(1);
		fall1.setFallID(e4321);
		FallID e1234 = new FallID(new ENummer("E1234"));
		e1234.setBefundTyp(BefundTyp.HAUPTBEFUND);
		e1234.setIndex(1);
		fall.setFallID(e1234);
		adresse.setHausnummer("12");
		adresse.setLand("Deutschland");
		adresse.setOrt("Hamburg");
		adresse.setPlz("12345");
		patient.setAdresse(adresse);
		patient.setVorname("Klaus");
		patient.setNachname("Kleber");
		patient.setGeburtsDatum(date);
		HashSet<Fall> objects = new HashSet<>(Arrays.asList(fall, fall1));
		patient.setFaelle(objects);
//		fallRepository.save(fall);
		patientRepository.save(patient);

//		patient.setNachname("Gollum");
//		patient.setId(2L);
//		patientRepository.save(patient);
//		Patient patient1 = new Patient();
//		patient1.setNachname("Kleber");
//		patient1.setVorname("Klaus");
//		patient1.setGeburtsDatum(date);
//		patientRepository.save(patient1);
	
	}
}