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

    public HashMap<String, Integer> getSheetsWithIndex() {
        Integer numberOfSheets = workbook.getNumberOfSheets();
        HashMap<String, Integer> sheetNamesWithIndex = new HashMap<>();
        for (int i = 0; i < numberOfSheets; i++) {
            sheetNamesWithIndex.put(workbook.getSheetName(i), i);
        }
        return sheetNamesWithIndex;
    }

    public Integer getNumberOfRows(Integer indexWorksheet) {
        XSSFSheet sheet = workbook.getSheetAt(indexWorksheet);
        return sheet.getPhysicalNumberOfRows();
    }

    public HashMap<String, Integer> getHeadlines(Integer indexWorksheet) {
		XSSFSheet sheet = workbook.getSheetAt(indexWorksheet);
		HashMap<String, Integer> headlines = new HashMap<>();
		XSSFRow row = sheet.getRow(0);
		int numberOfRows = row.getPhysicalNumberOfCells();
		for (int i = 0; i < numberOfRows; i++) {
			XSSFCell cell = row.getCell(i);
			headlines.put(getStringCellValue(cell), i);
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
