package de.pathologie_hh_west.service;

import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelServiceTest {
	
	@Autowired
	private ExcelService excelService;
	@Autowired
	private PatientRepository patientRepository;
	
	private ExcelFile excelFile;
	
	@Before
	public void setUp() throws Exception {
		excelFile = excelService.openExcelFile("src/test/testDaten/test.xlsx");
	}
	
	@Test
	public void getPatientWithDBCheck() throws Exception {
		//Patient for check with Excel
		Patient patient = new Patient();
		LocalDate date = LocalDate.of(2017, 7, 16);
		Fall fall = new Fall();
		Fall fall1 = new Fall();

		FallID e4321 = new FallID(new ENummer("001/00146"));
		e4321.setBefundTyp(BefundTyp.HAUPTBEFUND);
		fall1.setFallID(e4321);
		fall.setBefundtext("Klaus Kleber Setup 1");
		fall1.setBefundtext("Klaus Kleber Setup 2");
		FallID e1234 = new FallID(new ENummer("A/2000/200597"));
		e1234.setBefundTyp(BefundTyp.NACHBEFUND);
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
		patientRepository.save(patient);

//		Patient patientOptional = patientRepository.findByNachnameAndVornameAndGeburtsDatum("Apfel", "Klaudis", LocalDate.of(2000, 3, 1));
//		if (patientOptional.equals(null)) fail();
		
		Set<IndexMapper> mappers = new HashSet<>();
		mappers.add(new IndexMapper(0, PatientModelAttribute.VORNAME, true));
		mappers.add(new IndexMapper(1, PatientModelAttribute.NACHNAME, true));
		mappers.add(new IndexMapper(3, PatientModelAttribute.STRASSE, true));
		mappers.add(new IndexMapper(4, PatientModelAttribute.GEBURTSDATUM, true));
		mappers.add(new IndexMapper(7, PatientModelAttribute.ENUMMER, true));
		mappers.add(new IndexMapper(2, PatientModelAttribute.ALTERNATIVNAME, false));
		mappers.add(new IndexMapper(5, PatientModelAttribute.PLZ, true));
		mappers.add(new IndexMapper(6, PatientModelAttribute.BEFUNDTEXT, false));
		mappers.add(new IndexMapper(8, PatientModelAttribute.BEFUNDTYP, true));



		int sheetIndex = excelFile.getSheetsWithIndex().entrySet().stream()
				.filter(entry -> entry.getKey().equals("Tabelle1"))
				.map(Map.Entry::getValue)
				.limit(1).findFirst().get();


		excelService.updatePatientsFromExcel(mappers, excelFile, sheetIndex);


//		patientOptional = patientRepository.findByNachnameAndVornameAndGeburtsDatum("Apfel", "Klaudis", LocalDate.of(2000, 3, 1));
//		if (!patientOptional.equals(null)) fail();
	}
	
}