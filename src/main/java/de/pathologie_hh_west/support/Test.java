package de.pathologie_hh_west.support;

import de.pathologie_hh_west.data.FallRepository;
import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.*;
import de.pathologie_hh_west.service.ExcelFile;
import de.pathologie_hh_west.service.ExcelService;
import de.pathologie_hh_west.service.PatientModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by eike on 10.07.2017.
 */
@Component
public class Test implements CommandLineRunner {
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private FallRepository fallRepository;
//	@Autowired
//	private PatientZusatzdatenRepository patientZusatzdatenRepository;
	
	@Override
	public void run(String... strings) throws Exception {
		Patient patient = new Patient();
		LocalDate date = LocalDate.now();
		Fall fall = new Fall();
		Fall fall1 = new Fall();
		
		FallID e4321 = new FallID(new ENummer("001/00146"));
		e4321.setBefundTyp(BefundTyp.NACHBEFUND);
		e4321.setIndex(1);
		fall1.setFallID(e4321);
		FallID e1234 = new FallID(new ENummer("A/1996/200591"));
		e1234.setBefundTyp(BefundTyp.HAUPTBEFUND);
		e1234.setIndex(1);
		fall.setFallID(e1234);
		patient.getAdresse().setHausnummer("12");
		patient.getAdresse().setLand("Deutschland");
		patient.getAdresse().setOrt("Hamburg");
		patient.getAdresse().setPlz("12345");
		patient.setVorname("Klaus");
		patient.setNachname("Kleber");
		patient.setGeburtsDatum(date);
		HashSet<Fall> objects = new HashSet<>(Arrays.asList(fall, fall1));
		patient.setFaelle(objects);

//		fallRepository.save(fall);

		patientRepository.save(patient);
		String dateiPfad = "src/test/testDaten/test.xlsx";
		ExcelService excelService = new ExcelService();
		ExcelFile excelFile = excelService.openExcelFile(dateiPfad);

		excelFile.getHeadlines(0);
		Integer indexWorksheet = 0;
		HashMap<Integer, PatientModelAttribute> testMapPatientenZuExcelIndex = new HashMap<>();
		testMapPatientenZuExcelIndex.put(0, PatientModelAttribute.VORNAME);
		testMapPatientenZuExcelIndex.put(2, PatientModelAttribute.ALTERNATIVNAME);
		testMapPatientenZuExcelIndex.put(1, PatientModelAttribute.NACHNAME);
		testMapPatientenZuExcelIndex.put(3, PatientModelAttribute.STRASSE);
		testMapPatientenZuExcelIndex.put(4, PatientModelAttribute.GEBURTSDATUM);
		testMapPatientenZuExcelIndex.put(5, PatientModelAttribute.PLZ);
		for (int aktuelleZeile = 1; aktuelleZeile < excelFile.getNumberOfRows(indexWorksheet); aktuelleZeile++) {
			patient = excelService.patientDataFromExcel(testMapPatientenZuExcelIndex, aktuelleZeile, excelFile.getSheet(indexWorksheet));
			patientRepository.save(patient);
		}

		List<Patient> patienten = patientRepository.findByNachnameAndVornameAndGeburtsDatum("Apfel", "Klaudis", LocalDate.of(2000, 3, 1));
		if (!patienten.isEmpty()) {
			if (patienten.size() == 1) {
				Patient patientAusDatenbank = patienten.get(0);
			} else {
				throw new IllegalArgumentException("Eine eindeutige Zuordnung darf nicht mehr als einen Patienten ausgeben");
			}
			//TODO Patient existiert nicht
		}

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