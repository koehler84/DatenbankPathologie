package de.pathologie_hh_west.service;

import de.pathologie_hh_west.data.FallRepository;
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
import java.util.Iterator;
import java.util.Set;
import java.util.stream.IntStream;

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
	@Autowired
	private FallRepository fallRepository;

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

	public void updatePatientsFromExcel(final Set<IndexMapper> indexMappers, final ExcelFile excelFile, final Integer sheetIndex) {
		final XSSFSheet sheet = excelFile.getSheet(sheetIndex);
        IntStream.range(1, sheet.getPhysicalNumberOfRows()).
                parallel()
                .forEach(index -> getPatientWithDBCheck(indexMappers, index, sheet));
	}

	public Patient getPatientWithDBCheck(Set<IndexMapper> excelIndexPatientMapping, Integer currentRow, XSSFSheet sheet) {
        //TODO
        long timeMillis = System.currentTimeMillis();
        Patient patient = patientDataFromExcel(excelIndexPatientMapping, currentRow, sheet);
        System.out.println("Patient zusammen Bauen: " + (timeMillis - System.currentTimeMillis()));
        if (patient.getVorname() == null || patient.getNachname() == null || patient.getGeburtsDatum() == null) {
			return null;
			//throw new IllegalArgumentException("Kein eindeutiger Patient, es fehlt Vorname, Nachname oder Geburtsdatum");
		}
        //TODO
        timeMillis = System.currentTimeMillis();
        Patient patientAusDatenbank = patientRepository.findByNachnameAndVornameAndGeburtsDatum(patient.getNachname(), patient.getVorname(), patient.getGeburtsDatum());
        System.out.println("Patient aus DB lesen: " + (timeMillis - System.currentTimeMillis()));
        if (patientAusDatenbank != null) {
			patient.setId(patientAusDatenbank.getId());
			for (IndexMapper im : excelIndexPatientMapping) {
				if (im.getOverwriteExcelValue() || !patientAttributAuswahl.isDbValueNull(im.getPatientAttribut(), patientAusDatenbank)) {
					patient = patientAttributAuswahl.setValueFromDbToExcelPatient(im.getPatientAttribut(), patientAusDatenbank, patient);
				}
			}
			final Patient patientFinal = patient;
//			TODO benötigt?
//			if (patientAusDatenbank.getFaelle().stream().findFirst().get().getFallID().getBefundTyp() != null
//					&& patientAusDatenbank.getFaelle().stream().findFirst().get().getFallID().geteNummer().getValue() != "") {

			patientAusDatenbank.getFaelle().stream()
                    .filter(f -> !f.getFallID().geteNummer().getValue().equals(patientFinal.getFaelle().stream()
                            .findFirst().get().getFallID().geteNummer().getValue()))
                    .filter(g -> !g.getFallID().getBefundTyp().equals(patientFinal.getFaelle().stream()
							.findFirst().get().getFallID().getBefundTyp()))
					.forEach(patientFinal.getFaelle()::add);
			patient = patientFinal;
            //TODO
            System.out.println("Fälle mergen: " + (timeMillis - System.currentTimeMillis()));
//			}
		}
		//TODO Temporary - Fall überarbeiten
//		if (patient.getId() != null) {
//			patientRepository.delete(patient.getId());
//		}
        //TODO
        timeMillis = System.currentTimeMillis();
        patientRepository.save(patient);
        System.out.println("Patient speichern: " + (timeMillis - System.currentTimeMillis()));
        return patient;
	}

//	public Fall getFallWithDBCHeck(Set<IndexMapper> excelIndexFallMapping, Integer currentRow, XSSFSheet sheet) {
//		Fall fall = patientDataFromExcel(excelIndexFallMapping, currentRow, sheet);
//
//		return null;
//	}


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
