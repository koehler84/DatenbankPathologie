package de.pathologie_hh_west.service;

import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.Patient;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;

/**
 * Created by VaniR on 15.07.2017.
 * Project: path_db
 */
@Service
public class ExcelService {
    public ExcelService() {
    }

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

    public Patient getPatientwithDBCheck(HashMap<Integer, PatientModelAttribute> excelIndexPatientMapping, Integer currentRow, XSSFSheet sheet, PatientRepository patientRepository) {
        Patient patient = patientDataFromExcel(excelIndexPatientMapping, currentRow, sheet);
        List<Patient> patienten = patientRepository.findByNachnameAndVornameAndGeburtsDatum(patient.getNachname(), patient.getVorname(), patient.getGeburtsDatum());
        if (!patienten.isEmpty()) {
            if (patienten.size() == 1) {
                Patient patientAusDatenbank = patienten.get(0);
                //TODO vernünftiges mergen (Bestimmte Daten aus DB beistimmte aus Excel etc.)
                patient = patientAusDatenbank;
            } else {
                throw new IllegalArgumentException("Datenbank Inkonsistenz - Patient existiert doppelt");
            }
        }
        return patient;
    }

    private Patient patientDataFromExcel(HashMap<Integer, PatientModelAttribute> excelIndexPatientMapping, Integer currentRow, XSSFSheet sheet) {
        XSSFRow row = sheet.getRow(currentRow);
        Patient patient = new Patient();
        for (Integer cellIndex : excelIndexPatientMapping.keySet()) {
            XSSFCell cell = row.getCell(cellIndex);
            if (cell != null) {
                switch (cell.getCellType()) {
                    case XSSFCell.CELL_TYPE_FORMULA:
                        patient = new PatientAttributAuswahl(cell.getCellFormula(), excelIndexPatientMapping.
                                get(cellIndex), patient).getPatient();
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            patient = new PatientAttributAuswahl(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).
                                    toLocalDate(), excelIndexPatientMapping.get(cellIndex), patient).getPatient();

                        } else {
                            new PatientAttributAuswahl(BigDecimal.valueOf(cell.getNumericCellValue()), excelIndexPatientMapping.
                                    get(cellIndex), patient).getPatient();
                        }
                        break;
                    case XSSFCell.CELL_TYPE_STRING:
                        patient = new PatientAttributAuswahl(cell.getStringCellValue(), excelIndexPatientMapping.
                                get(cellIndex), patient).getPatient();
                        break;
                    case XSSFCell.CELL_TYPE_BLANK:
                        patient = new PatientAttributAuswahl("", excelIndexPatientMapping.
                                get(cellIndex), patient).getPatient();
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        patient = new PatientAttributAuswahl(cell.getBooleanCellValue() + "", excelIndexPatientMapping.
                                get(cellIndex), patient).getPatient();
                        break;
                    case XSSFCell.CELL_TYPE_ERROR:
                        patient = new PatientAttributAuswahl(cell.getErrorCellValue() + "", excelIndexPatientMapping.
                                get(cellIndex), patient).getPatient();
                        break;

                    default:
                        patient = new PatientAttributAuswahl("<FEHLER IM PROGRAMM>", excelIndexPatientMapping.
                                get(cellIndex), patient).getPatient();
                }
            }
        }
        return patient;
    }

}
