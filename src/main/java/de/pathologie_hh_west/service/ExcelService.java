package de.pathologie_hh_west.service;

import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.Fall;
import de.pathologie_hh_west.model.Patient;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by VaniR on 15.07.2017.
 * Project: path_db
 */
@Service
public class ExcelService {
	
	@Autowired
	private PatientAttributAuswahl patientAttributAuswahl;
	@Autowired
	private PatientRepository patientRepository;
	public Set<Integer> debug = new HashSet<>();
	
	public ExcelFile openExcelFile(String filePath) {
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			//TODO
		}
		return new ExcelFile(workbook);
	}
	
	public DataUpdateWrapper getUpdatedPatientsFromExcel(final Set<IndexMapper> indexMappers, final ExcelFile excelFile, final Integer sheetIndex) throws Exception {
		long count = indexMappers.stream()
				.filter(mapper -> {
					switch (mapper.getPatientAttribut()) {
						case VORNAME:
						case NACHNAME:
						case GEBURTSDATUM:
							return true;
						default:
							return false;
					}
				})
				.count();
		if (count != 3) throw new IllegalArgumentException("Kein eindeutiger Patient, es fehlt Vorname, Nachname oder Geburtsdatum");
		
		return new DataUpdateWrapper(this, patientRepository, indexMappers, excelFile, sheetIndex);
	}
	
	public Patient getPatientWithDBCheck(Set<IndexMapper> excelIndexPatientMapping, Integer currentRow, XSSFSheet sheet) {
		long timeMillis = System.currentTimeMillis();
        Patient patientAusExcel = patientDataFromExcel(excelIndexPatientMapping, currentRow, sheet);
        Patient patient = patientAusExcel;
        patientAusExcel.setAlternativName(null);
        //System.out.println("Patient zusammen Bauen: " + (timeMillis - System.currentTimeMillis()));
        if (patientAusExcel.getVorname() == null || patientAusExcel.getNachname() == null || patientAusExcel.getGeburtsDatum() == null) {
            throw new IllegalArgumentException("Kein eindeutiger Patient, es fehlt Vorname, Nachname oder Geburtsdatum");
		}
        Patient patientAusDatenbank = patientRepository.findByNachnameAndVornameAndGeburtsDatum(patientAusExcel.getNachname(), patientAusExcel.getVorname(), patientAusExcel.getGeburtsDatum());
        if (patientAusDatenbank != null) {
            patient = patientAusDatenbank;
            for (IndexMapper im : excelIndexPatientMapping) {
                if (!im.getOverwriteExcelValue() || patientAttributAuswahl.isDbValueNull(im.getPatientAttribut(), patientAusDatenbank)) {
                    patient = patientAttributAuswahl.setValueFromExcelToDbPatient(im.getPatientAttribut(), patientAusExcel, patientAusDatenbank);
                }
			}
//			final Patient patientFinal = patient;
//			patientAusDatenbank.getFaelle().stream()
//					.filter(f -> !f.getFallID().geteNummer().getValue().equals(patientFinal.getFaelle().stream()
//							.findFirst().get().getFallID().geteNummer().getValue()))
//					.filter(g -> !g.getFallID().getBefundTyp().equals(patientFinal.getFaelle().stream()
//							.findFirst().get().getFallID().getBefundTyp()))
//					.forEach(patientFinal.getFaelle()::add);
//			patient = patientFinal;
        }
		//TODO Temporary - Fall überarbeiten
//		if (patient.getId() != null) {
//			patientRepository.delete(patient.getId());
//		}
		debug.remove(currentRow);
		return patient;
	}
	
	private Patient patientDataFromExcel(Set<IndexMapper> excelIndexPatientMapping, Integer currentRow, XSSFSheet sheet) {

		XSSFRow row = sheet.getRow(currentRow);
		Patient patient = new Patient();
		patient.getFaelle().add(new Fall());
		for (Iterator<IndexMapper> it = excelIndexPatientMapping.iterator(); it.hasNext(); ) {
			IndexMapper indexMapper = it.next();
			Integer cellIndex = indexMapper.getExcelIndex();
			XSSFCell cell = row.getCell(cellIndex);
			if (cell != null) {
				switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_FORMULA:
						patient = patientAttributAuswahl.mapExcelValueToPatient(cell.getCellFormula(), indexMapper.getPatientAttribut(),
								patient);
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							patient = patientAttributAuswahl.mapExcelValueToPatient(cell.getDateCellValue().toInstant().
											atZone(ZoneId.systemDefault()).toLocalDate(), indexMapper.getPatientAttribut(),
									patient);
							
						} else {
							patient = patientAttributAuswahl.mapExcelValueToPatient(BigDecimal.valueOf(cell.getNumericCellValue()), indexMapper.
									getPatientAttribut(), patient);
						}
						break;
					case XSSFCell.CELL_TYPE_STRING:
						patient = patientAttributAuswahl.mapExcelValueToPatient(cell.getStringCellValue(), indexMapper.getPatientAttribut(),
								patient);
						break;
					case XSSFCell.CELL_TYPE_BLANK:
						patient = patientAttributAuswahl.mapExcelValueToPatient("", indexMapper.getPatientAttribut(),
								patient);
						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						patient = patientAttributAuswahl.mapExcelValueToPatient(cell.getBooleanCellValue(), indexMapper.getPatientAttribut(),
								patient);
						break;
					case XSSFCell.CELL_TYPE_ERROR:
						patient = patientAttributAuswahl.mapExcelValueToPatient(cell.getErrorCellValue() + "", indexMapper.getPatientAttribut(),
								patient);
						break;
					
					default:
						patient = patientAttributAuswahl.mapExcelValueToPatient("<FEHLER IM PROGRAMM>", indexMapper.getPatientAttribut(),
								patient);
				}
			}
		}
		return patient;
	}
	
}
