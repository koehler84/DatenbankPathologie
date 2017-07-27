package de.pathologie_hh_west.service.excelexport

import de.pathologie_hh_west.model.ENummer
import de.pathologie_hh_west.model.Fall
import de.pathologie_hh_west.model.FallID
import de.pathologie_hh_west.model.Patient
import de.pathologie_hh_west.service.PatientModelAttribute
import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.time.LocalDate

class ExcelFileExportTest {
	
	private val patients: Collection<Patient>
	private val attributes: List<PatientModelAttribute>
	private val excelFileExport: ExcelFileExport
	
	init {
		val targetFilePath = "src/test/testDaten/excelfileexporttest.xlsx"
		val file = File(targetFilePath)
		if (file.exists()) file.delete()
		
		val fall = Fall()
		fall.fallID = FallID(ENummer("A/1996/200591"))
		
		val pat1 = Patient()
		pat1.vorname = "Hans"
		pat1.nachname = "Peter"
		pat1.geburtsDatum = LocalDate.of(2017, 5, 5)
		pat1.faelle.add(fall)
		val pat2 = Patient()
		pat2.vorname = "Hans2"
		pat2.nachname = "Peter2"
		pat2.geburtsDatum = LocalDate.of(2017, 10, 10)
		pat2.faelle.add(fall)
		patients = listOf(pat1, pat2)
		
		attributes = listOf(PatientModelAttribute.VORNAME, PatientModelAttribute.NACHNAME, PatientModelAttribute.GEBURTSDATUM, PatientModelAttribute.ENUMMER)
		excelFileExport = ExcelFileExport(targetFilePath, attributes, patients)
	}
	
	@Test
	fun createExcelFileExportWithExistingFileNameAndExpectException() {
		try {
			ExcelFileExport("src/test/testDaten/test.xlsx", attributes, patients)
			fail()
		} catch(e: Exception) {
		}
	}
	
	@Test
	fun createExcelFileExportWithNewFileNameAndExpectSuccess() {
		try {
			ExcelFileExport("src/test/testDaten/excelfileexporttest.xlsx", attributes, patients)
		} catch(e: Exception) {
			fail()
		}
	}
	
	@Test
	fun name() {
		excelFileExport.writePatients()
	}
}