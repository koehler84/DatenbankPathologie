package de.pathologie_hh_west.service;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.HashMap;

/**
 * Created by VaniR on 15.07.2017.
 * Project: path_db
 */
public class ExcelFile {
    private XSSFWorkbook workbook;

    public ExcelFile(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    //TODO catch bei leeren Mappen etc
    public HashMap<Integer, String> getSheetsWithIndex() {
        Integer numberOfSheets = workbook.getNumberOfSheets();
        HashMap<Integer, String> sheetNamesWithIndex = new HashMap<>();
        for (int i = 0; i < numberOfSheets; i++) {
            sheetNamesWithIndex.put(i, workbook.getSheetName(i));
        }
        return sheetNamesWithIndex;
    }

    public Integer getNumberOfRows(Integer indexWorksheet) {
        XSSFSheet sheet = workbook.getSheetAt(indexWorksheet);
        return sheet.getPhysicalNumberOfRows();
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

    public XSSFSheet getSheet(Integer indexSheet) {
        return workbook.getSheetAt(indexSheet);
    }
}
