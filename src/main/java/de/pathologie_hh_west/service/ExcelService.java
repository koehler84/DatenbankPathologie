package de.pathologie_hh_west.service;

import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.*;
import de.pathologie_hh_west.support.DeepCopy;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        Patient patientAusExcel = patientDataFromExcel(excelIndexPatientMapping, currentRow, sheet);
		Patient patient = (Patient) DeepCopy.copy(patientAusExcel);
		if (patientAusExcel.getVorname() == null || patientAusExcel.getNachname() == null || patientAusExcel.getGeburtsDatum() == null) {
            throw new IllegalArgumentException("Kein eindeutiger Patient, es fehlt Vorname, Nachname oder Geburtsdatum");
        }
        Patient patientAusDatenbank = patientRepository.findByNachnameAndVornameAndGeburtsDatum(patientAusExcel.getNachname(), patientAusExcel.getVorname(), patientAusExcel.getGeburtsDatum());
        if (patientAusDatenbank != null) {
            if (patientAusDatenbank.getAdresse() == null) patientAusDatenbank.setAdresse(new Adresse());
            if (patientAusDatenbank.getFaelle() == null) patientAusDatenbank.setFaelle(new HashSet<Fall>());
            for (Fall fall : patientAusDatenbank.getFaelle()) {
                if (fall.getFallID() == null) fall.setFallID(new FallID());
                if (fall.getKlassifikation() == null) fall.setKlassifikation(new Klassifikation());
                if (fall.getKlassifikation().getTumorArt() == null)
                    fall.getKlassifikation().setTumorArt(new TumorArt());
            }
            if (patientAusDatenbank.getPatientenZusatzdaten() == null)
                patientAusDatenbank.setPatientenZusatzdaten(new PatientenZusatzdaten());
            if (patientAusDatenbank.getPatientenZusatzdaten().getExprimage() == null)
                patientAusDatenbank.getPatientenZusatzdaten().setExprimage(new Exprimage());
            if (patientAusDatenbank.getPatientenZusatzdaten().getEe2011() == null)
                patientAusDatenbank.getPatientenZusatzdaten().setEe2011(new EE2011());
            if (patientAusDatenbank.getPatientenZusatzdaten().getEe2015() == null)
                patientAusDatenbank.getPatientenZusatzdaten().setEe2015(new EE2015());


			patient = (Patient) DeepCopy.copy(patientAusDatenbank);

			patient.setFaelle(new HashSet<Fall>());
			if (patientAusDatenbank.getFaelle().stream()
					.filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream()
                            .findFirst().get().getFallID().geteNummer().getValue()))
                    .filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
                            .findFirst().get().getFallID().getBefundTyp()))
                    .findFirst()
                    .isPresent()) {
				patient.getFaelle().add(patientAusDatenbank.getFaelle().stream()
						.filter(f -> f.getFallID().geteNummer().getValue().equals(patientAusExcel.getFaelle().stream()
								.findFirst().get().getFallID().geteNummer().getValue()))
						.filter(g -> g.getFallID().getBefundTyp().equals(patientAusExcel.getFaelle().stream()
								.findFirst().get().getFallID().getBefundTyp()))
						.findFirst().get());
			} else {
				patient.getFaelle().add(new Fall());
			}



            for (IndexMapper im : excelIndexPatientMapping) {
                if (!im.getOverwriteExcelValue()) {
                    patient = patientAttributAuswahl.setValueFromExcelToDbPatient(im.getPatientAttribut(), patientAusExcel, patient);
                }
            }
		}
		try {
			Fall test1 = patient.getFaelle().stream().findFirst().get();
			Fall test2 = patientAusDatenbank.getFaelle().stream().findFirst().get();
			System.out.println(test1.equals(test2) + " " + test1.hashCode() + " | " + test2.hashCode());
		} catch (Exception e) {

		}
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
                        if (cell.getStringCellValue().matches("\\d\\d\\d\\d-\\d\\d-\\d\\d")) {
                            patient = patientAttributAuswahl.mapExcelValueToPatient(LocalDate.parse(cell.getStringCellValue(), DateTimeFormatter.ISO_DATE), indexMapper.getPatientAttribut(),
                                    patient);
                        } else {
                            patient = patientAttributAuswahl.mapExcelValueToPatient(cell.getStringCellValue(), indexMapper.getPatientAttribut(),
                                    patient);
                        }
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
