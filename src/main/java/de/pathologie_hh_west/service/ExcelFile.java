package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.Patient;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.HashMap;

/**
 * Created by VaniR on 15.07.2017.
 */
public class ExcelFile {
    private XSSFWorkbook workbook;

    public ExcelFile(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            this.workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            //TODO
        }
    }

    public HashMap<Integer, String> getSheetsWithIndex() {
        Integer numberOfSheets = workbook.getNumberOfSheets();
        HashMap<Integer, String> sheetNamesWithIndex = new HashMap<>();
        for (int i = 0; i < numberOfSheets; i++) {
            sheetNamesWithIndex.put(i, workbook.getSheetName(i));
        }
        return sheetNamesWithIndex;
    }

    public HashMap<Integer, String> getHeadlines(Integer indexWorksheet) {
        XSSFSheet sheet = workbook.getSheetAt(indexWorksheet);
        HashMap<Integer, String> headlines = new HashMap<>();
        XSSFRow row = sheet.getRow(0);
        int numberOfRows = row.getPhysicalNumberOfCells();
        for (int i = 0; i < numberOfRows; i++) {
            XSSFCell cell = row.getCell(i);
            headlines.put(i, getStringCellValue(cell));
        }
        return headlines;
    }

    private String getStringCellValue(XSSFCell cell) {
        String cellValue = null;
        if (cell != null) {
            switch (cell.getCellType()) {

                case XSSFCell.CELL_TYPE_FORMULA:
                    cellValue = cell.getCellFormula();
                    break;

                case XSSFCell.CELL_TYPE_NUMERIC:
                    cellValue = cell.getNumericCellValue() + "";
                    break;

                case XSSFCell.CELL_TYPE_STRING:
                    cellValue = cell.getStringCellValue();
                    break;

                case XSSFCell.CELL_TYPE_BLANK:
                    cellValue = "";
                    break;

                case XSSFCell.CELL_TYPE_BOOLEAN:
                    cellValue = cell.getBooleanCellValue() + "";
                    break;

                case XSSFCell.CELL_TYPE_ERROR:
                    cellValue = cell.getErrorCellValue() + "";
                    break;

                default:
                    cellValue = "<FEHLER IM PROGRAMM>";
            }
        }
        return cellValue;
    }

    public Patient patientDataFromExcel(HashMap<Integer, PatientModelAttribute> excelIndexPatientMapping, Integer currentRow, XSSFSheet sheet) {


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
