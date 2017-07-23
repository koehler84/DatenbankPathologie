package de.pathologie_hh_west.support;

import de.pathologie_hh_west.data.FallRepository;
import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.*;
import de.pathologie_hh_west.service.ExcelFile;
import de.pathologie_hh_west.service.ExcelService;
import de.pathologie_hh_west.service.IndexMapper;
import de.pathologie_hh_west.service.PatientModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by eike on 10.07.2017.
 */
@Component
public class Test implements CommandLineRunner {
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private FallRepository fallRepository;
	@Autowired
	private ExcelService excelService;
	
	@Override
	public void run(String... strings) throws Exception {
		Patient patient = new Patient();
		LocalDate date = LocalDate.of(2017, 7, 16);
		Fall fall = new Fall();
		Fall fall1 = new Fall();
		
		FallID e4321 = new FallID(new ENummer("001/00146"));
		e4321.setBefundTyp(BefundTyp.NACHBEFUND);
		fall1.setFallID(e4321);
		FallID e1234 = new FallID(new ENummer("A/1996/200591"));
		e1234.setBefundTyp(BefundTyp.HAUPTBEFUND);
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
		ExcelFile excelFile = excelService.openExcelFile(dateiPfad);

		HashMap<String, Integer> headlines = excelFile.getHeadlines(0);
		Integer indexWorksheet = 0;
		Set<IndexMapper> testMapPatientenZuExcelIndex = new HashSet<>();
		testMapPatientenZuExcelIndex.add(new IndexMapper(0, PatientModelAttribute.VORNAME, false));
		testMapPatientenZuExcelIndex.add(new IndexMapper(2, PatientModelAttribute.ALTERNATIVNAME, false));
		testMapPatientenZuExcelIndex.add(new IndexMapper(1, PatientModelAttribute.NACHNAME, false));
		testMapPatientenZuExcelIndex.add(new IndexMapper(3, PatientModelAttribute.STRASSE, false));
		testMapPatientenZuExcelIndex.add(new IndexMapper(4, PatientModelAttribute.GEBURTSDATUM, false));
		testMapPatientenZuExcelIndex.add(new IndexMapper(5, PatientModelAttribute.PLZ, false));
		testMapPatientenZuExcelIndex.add(new IndexMapper(6, PatientModelAttribute.BEFUNDTEXT, false));
//		for (int aktuelleZeile = 1; aktuelleZeile < excelFile.getNumberOfRows(indexWorksheet); aktuelleZeile++) {
//			patient = excelService.getPatientWithDBCheck(testMapPatientenZuExcelIndex, aktuelleZeile, excelFile.getSheet(indexWorksheet));
//			patientRepository.save(patient);
//		}


		System.out.println();
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