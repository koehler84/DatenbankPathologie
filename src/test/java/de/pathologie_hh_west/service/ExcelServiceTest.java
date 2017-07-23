package de.pathologie_hh_west.service;

import de.pathologie_hh_west.config.TestingDataSourceConfig;
import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.Patient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

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
		Optional<Patient> patientOptional = patientRepository.findByNachnameAndVornameAndGeburtsDatum("Apfel", "Klaudis", LocalDate.of(2000, 3, 1)).stream().findFirst();
		if (patientOptional.isPresent()) fail();
		
		Set<IndexMapper> mappers = new HashSet<>();
		mappers.add(new IndexMapper(0, PatientModelAttribute.VORNAME, true));
		mappers.add(new IndexMapper(1, PatientModelAttribute.NACHNAME, true));
		mappers.add(new IndexMapper(3, PatientModelAttribute.STRASSE, true));
		mappers.add(new IndexMapper(4, PatientModelAttribute.GEBURTSDATUM, true));
		mappers.add(new IndexMapper(7, PatientModelAttribute.ENUMMER, true));
		
		int sheetIndex = excelFile.getSheetsWithIndex().entrySet().stream()
				.filter(entry -> entry.getKey().equals("Tabelle1"))
				.map(Map.Entry::getValue)
				.limit(1).findFirst().get();
		
		Patient patientWithDBCheck = excelService.getPatientWithDBCheck(mappers, 2, excelFile.getSheet(sheetIndex));
		
		patientOptional = patientRepository.findByNachnameAndVornameAndGeburtsDatum("Apfel", "Klaudis", LocalDate.of(2000, 3, 1)).stream().findFirst();
		if (!patientOptional.isPresent()) fail();
	}
	
}